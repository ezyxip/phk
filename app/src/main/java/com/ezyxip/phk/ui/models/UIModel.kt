package com.ezyxip.phk.ui.models

object UIModel {
    fun getMenuItems(): List<MenuItem> {
        return listOf(
            MenuItem("Курсы"),
            MenuItem(),
            MenuItem()
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