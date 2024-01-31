package com.ezyxip.phk.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ezyxip.phk.ui.models.MenuItem
import com.ezyxip.phk.ui.models.UIModel
import com.ezyxip.phk.ui.screens.Screen

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    items: List<MenuItem> = listOf(MenuItem()),
    navigate: (Screen) -> Unit = {}
){
    ModalDrawerSheet (
        modifier = modifier.fillMaxWidth(0.6f)
    ) {
        for(i in items){
            NavigationDrawerItem(
                icon = {Icon(imageVector = i.icon, contentDescription = null)},
                label = { Text(text = i.name) },
                selected = false,
                onClick = {navigate(i.route)}
            )
        }
    }
}

@Preview
@Composable
fun MenuPreview(){
    Menu(items = UIModel.getMenuItems())
}