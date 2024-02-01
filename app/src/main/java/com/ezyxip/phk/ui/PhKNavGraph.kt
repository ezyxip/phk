package com.ezyxip.phk.ui

import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.navArgument
import com.ezyxip.phk.ui.screens.ScreenHub

fun getNavGraph(navController: NavHostController): NavGraph {
    return navController.createGraph(startDestination = ScreenHub.Main.path){
        for (i in ScreenHub.entries){
            composable(
                route = i.path,
                arguments = i.arguments.map { elem -> navArgument(elem){type = NavType.StringType} }
            ){
                val args = mutableMapOf<String, String?>()
                i.arguments.forEach { elem -> args[elem] = it.arguments?.getString(elem) }

                i.screenContent(args, navController)
            }
        }
    }
}