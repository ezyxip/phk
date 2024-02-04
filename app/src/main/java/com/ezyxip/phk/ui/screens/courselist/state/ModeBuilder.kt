package com.ezyxip.phk.ui.screens.courselist.state

import androidx.compose.runtime.Composable

class ModeBuilder(
    navigateToEditScreen: (Int) -> Unit,
    selectCourse: (Int) -> Unit,
    addNewCourse: () -> Int,
    deleteCourses: () -> Unit,
    listOfSelectedCards: List<Int>
) : CourseListScreenState {

    private val state: CourseListScreenState =
        if (listOfSelectedCards.isEmpty())
            NormalMode(
                navigateToEditScreen,
                selectCourse,
                addNewCourse,
            )
        else
            SelectedMode(
                selectCourse,
                deleteCourses,
            )
    override val onCardClick: (Int) -> Unit
        get() = state.onCardClick
    override val onCardPress: (Int) -> Unit
        get() = state.onCardPress
    override val title: String
        get() = state.title
    override val headerRightBar: @Composable () -> Unit
        get() = state.headerRightBar
}