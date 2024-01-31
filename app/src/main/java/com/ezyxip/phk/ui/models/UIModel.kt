package com.ezyxip.phk.ui.models

object UIModel {
    fun getMenuItems(): List<MenuItem> {
        return listOf<MenuItem>(
            MenuItem("Курсы"),
            MenuItem(),
            MenuItem()
        )
    }
}