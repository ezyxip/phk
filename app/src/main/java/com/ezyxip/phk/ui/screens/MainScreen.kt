package com.ezyxip.phk.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ezyxip.phk.ui.components.MenuableScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
){
    MenuableScreen (
        modifier = modifier
    ){
        Column(
            modifier = modifier
        ) {
            Text("Main screen")
        }
    }
}