package com.ezyxip.phk.ui.models
import com.ezyxip.phk.ui.screens.Screen

object UIModel {
    fun getCourses(): List<CoursePresentation>{
        return listOf(
            CoursePresentation(name = "Алгебра"),
            CoursePresentation(name = "Матанализ"),
            CoursePresentation(name = "Аналитическая геометрия"),
            CoursePresentation(name = "Практика речевой деятельности"),
        )
    }
    fun getMenuItems(): List<MenuItem> {
        return listOf(
            MenuItem("Главная"),
            MenuItem("Курсы", route = Screen.CourseList),
            MenuItem("Помощь", route = Screen.Default)
        )
    }

    fun getLastLessons(): List<LessonPresentation>{
        return listOf(
            LessonPresentation(title = "title1"),
            LessonPresentation(title = "title2"),
            LessonPresentation(title = "title3")
        )
    }
}