package com.ezyxip.phk.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddButton(
    modifier: Modifier = Modifier,
    tint: Color = Color.White,
    onClick: () -> Unit = {}
){
    Icon(
        modifier = modifier
            .clickable { onClick() }
            .padding(10.dp, 0.dp),
        imageVector = Icons.Filled.Add,
        contentDescription = null,
        tint = tint
    )
}