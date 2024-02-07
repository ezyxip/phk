package com.ezyxip.phk.ui.screens.courseedit.state

import androidx.compose.runtime.Composable
import com.ezyxip.phk.ui.components.DeleteButton

class SelectedMode (
    toggleSelectionOfCard: (Int) -> Unit,
    deleteCourses: () -> Unit
) : CourseEditState {
    override val title: String = "Выделелние..."
    override val onCardClick: (Int) -> Unit = toggleSelectionOfCard
    override val onCardPress: (Int) -> Unit = toggleSelectionOfCard
    override val headerRightBar: @Composable () -> Unit = {
        DeleteButton{
            deleteCourses()
        }
    }

}