package com.example.tugas1ppb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BadgedBox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugas1ppb.presentation.BottomNavItem
import com.example.tugas1ppb.presentation.Navigation
import com.example.tugas1ppb.ui.theme.Tugas1ppbTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tugas1ppbTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        //Fungsi Custom Composable
                        BottomNavBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Biodata",
                                    route ="Biodata",
                                    icon = Icons.Default.AccountCircle ,
                                ),
                                BottomNavItem(
                                    name = "Skill" ,
                                    route = "skill",
                                    icon = Icons.Default.Star ,
                                ),
                                BottomNavItem(
                                    name = "Project" ,
                                    route = "project",
                                    icon = Icons.Default.Build ,
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navHost = navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavBar(
    items:List<BottomNavItem>,
    navController:NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
){
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Blue,
        elevation = 5.dp,
    ) {
        items.forEach{
            item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item)},
                icon = {
                       Column(horizontalAlignment = CenterHorizontally
                       ) {
                            if(item.badgeCount > 0) {
                                BadgedBox(badge = {
                                    Text(text = item.badgeCount.toString())
                                }) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = null
                                    )
                                }
                            }
                           else{
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = null
                                )
                            }
                           if(selected){
                               Text(
                                   text = item.name,
                                   textAlign = TextAlign.Center,
                                   fontSize = 10.sp,
                               )
                           }
                       }
                },
            selectedContentColor = Color.Green,
            unselectedContentColor = Color.Gray)
        }
    }
}