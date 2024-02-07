package com.ezyxip.phk.ui.screens.courseedit.state

import androidx.compose.runtime.Composable

interface CourseEditState {
    val title: String
    val onCardClick: (Int) -> Unit
    val onCardPress: (Int) -> Unit
    val headerRightBar: @Composable () -> Unit
}