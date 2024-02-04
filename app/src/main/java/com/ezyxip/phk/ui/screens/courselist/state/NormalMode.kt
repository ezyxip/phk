package com.ezyxip.phk.ui.screens.courselist.state

import androidx.compose.runtime.Composable
import com.ezyxip.phk.ui.components.AddButton

class NormalMode (
    navigateToEditScreen: (Int) -> Unit,
    selectCourse: (Int) -> Unit,
    addNewCourse: () -> Int
) : CourseListScreenState {
    override val onCardClick: (Int) -> Unit = navigateToEditScreen
    override val onCardPress: (Int) -> Unit = selectCourse
    override val title: String = "Курсы"
    override val headerRightBar: @Composable () -> Unit = {
        AddButton {
            val id = addNewCourse()
            navigateToEditScreen(id)
        }
    }
}