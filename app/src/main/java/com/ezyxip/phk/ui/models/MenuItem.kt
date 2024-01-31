package com.ezyxip.phk.ui.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem (
    val name: String = "menu item",
    val icon: ImageVector = Icons.Filled.Star,
    val navigate: () -> Unit = {}
)