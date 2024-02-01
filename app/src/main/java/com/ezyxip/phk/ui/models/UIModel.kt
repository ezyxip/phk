package com.ezyxip.phk.ui.models
import com.ezyxip.phk.ui.screens.ScreenHub

object UIModel {
    fun getMenuItems(): List<MenuItem> {
        return listOf(
            MenuItem("Главная"),
            MenuItem("Курсы", route = ScreenHub.CourseList),
            MenuItem("Помощь", route = ScreenHub.Default)
        )
    }
}