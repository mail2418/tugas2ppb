package com.example.tugas1ppb.presentation.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tugas1ppb.R

@Composable
fun ProjectNav(){
    val listProjects = listOf(
        ProjectItem(
            "ERP ITS",
            painterResource(id=R.drawable.project1),
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
        ),
        ProjectItem(
            "ERP ITS 2",
            painterResource(id=R.drawable.project1),
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
        )
    )
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true,
    ){
        items(listProjects) { item ->
            ElevatedCard{
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = item.name)
                    Image(painter = item.painter, contentDescription = null, modifier= Modifier
                        .clip(RoundedCornerShape(16.dp))
                    )
                    Text(text = item.desc.toString())
                }
            }
        }
    }
}
