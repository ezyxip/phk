package com.ezyxip.phk.ui.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.ezyxip.phk.ui.screens.Screen

data class MenuItem (
    val name: String = "menu item",
    val icon: ImageVector = Icons.Filled.Star,
    val route: Screen = Screen.Main
)