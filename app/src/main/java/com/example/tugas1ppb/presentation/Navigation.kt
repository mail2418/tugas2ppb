package com.example.tugas1ppb.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tugas1ppb.presentation.biodata.BiodataNav
import com.example.tugas1ppb.presentation.project.ProjectNav
import com.example.tugas1ppb.presentation.skill.SkillNav

@Composable
fun Navigation(navHost: NavHostController) {
    NavHost(navController = navHost, startDestination = "biodata") {
        composable("biodata"){
            BiodataNav()
        }
        composable("skill"){
            SkillNav()
        }
        composable("project"){
            ProjectNav()
        }
    }
}
