package com.ezyxip.phk.ui.screens.courselist.state

import androidx.compose.runtime.Composable

interface CourseListScreenState {
    val onCardClick: (Int) -> Unit
    val onCardPress: (Int) -> Unit
    val title: String
    val headerRightBar: @Composable () -> Unit
}