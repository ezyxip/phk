package com.ezyxip.phk.ui.theme

import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.ezyxip.phk.ui.screens.MainScreen
import com.ezyxip.phk.ui.screens.Screens

fun getNavGraph(navController: NavHostController): NavGraph {
    return navController.createGraph(startDestination = Screens.Main.path){
        composable(Screens.Main.path){
            MainScreen()
        }
    }
}