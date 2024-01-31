package com.ezyxip.phk.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ezyxip.phk.ui.components.AddButton
import com.ezyxip.phk.ui.components.MenuableScreen

@Composable
fun CourseEditScreen(
    modifier: Modifier = Modifier,
    args: Map<String, String?>,
    navigator: NavHostController
){
    MenuableScreen (
        modifier = modifier,
        title = "Конспекты",
        navigate = {navigator.navigate(it.path)},
        rightButton = {
            AddButton(
                modifier = modifier,
                onClick = {
                    navigator.navigate(Screen.LessonEdit.pathWithArg("0"))
                }
            )}
    ) {

    }
}