package com.ezyxip.phk.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ezyxip.phk.ui.models.UIModel
import kotlinx.coroutines.launch

@Composable
fun MenuableScreen(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    val drawerController = rememberDrawerState(initialValue = DrawerValue.Closed)
    val menuItems = UIModel.getMenuItems()

    ModalNavigationDrawer(
        modifier = modifier,
        drawerContent = {
            Menu(modifier = modifier, items = menuItems)
        },
        drawerState = drawerController
    ) {
        MenuableBody(
            modifier = modifier,
            drawerController = drawerController,
            content = content
        )
    }
}

@Composable
private fun MenuableBody(
    modifier: Modifier = Modifier,
    drawerController : DrawerState,
    content: @Composable () -> Unit
){
    Scaffold(
        modifier = modifier,
        topBar = { PhKTopAppBar(drawerController = drawerController)}
    ) { paddingValues ->
        Box(
            modifier = modifier.padding(paddingValues)
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhKTopAppBar(
    modifier: Modifier = Modifier,
    drawerController : DrawerState,
){
    TopAppBar(
        title = { PhKTopMenuBarTitle(modifier = modifier, drawerController = drawerController)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        )
    )
}

@Composable
private fun PhKTopMenuBarTitle(
    modifier: Modifier = Modifier,
    drawerController : DrawerState
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MenuButton(drawerController = drawerController)
        Spacer(
            modifier.padding(10.dp)
        )
        Text("Фотоконспект")
    }
}

@Composable
private fun MenuButton(
    modifier: Modifier = Modifier,
    drawerController : DrawerState
){
    val scope = rememberCoroutineScope()
    Icon(
        modifier = modifier.clickable {
            scope.launch {
                drawerController.apply {
                    if(isClosed) open() else close()
                }
            }
        },
        imageVector = Icons.Filled.Menu,
        contentDescription = "menu icon",
        tint = Color.White
    )
}