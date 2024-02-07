package com.ezyxip.phk.ui.screens.lessonedit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ezyxip.phk.ui.components.MenuableScreen
import com.ezyxip.phk.ui.models.LessonPresentation

@Composable
fun LessonEditScreen(
    modifier: Modifier = Modifier,
    args: Map<String, String?>,
    navigator: NavHostController,
    getLessonById: (Int) -> LessonPresentation
){
    val lessonId = args["lessonId"] ?: throw Exception("Не передано lessonId")
    val currentLesson: LessonPresentation = getLessonById(lessonId.toInt())
    MenuableScreen (
        modifier = modifier,
        title = currentLesson.title,
        navigate = {screen -> navigator.navigate(screen.path) },

    ) {
        Text(text = "HelloWorld! Lesson ${currentLesson.title}")
    }
}