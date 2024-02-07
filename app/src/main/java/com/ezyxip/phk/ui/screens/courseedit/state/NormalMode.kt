package com.ezyxip.phk.ui.screens.courseedit.state

import androidx.compose.runtime.Composable
import com.ezyxip.phk.ui.components.AddButton

class NormalMode (
    navToLessonEdit: (Int) -> Unit,
    toggleSelectionOfCard: (Int) -> Unit,
    addNewLessonAndNav: ()->Unit
) : CourseEditState {
    override val title: String = "Конспекты"
    override val onCardClick: (Int) -> Unit = navToLessonEdit
    override val onCardPress: (Int) -> Unit = toggleSelectionOfCard
    override val headerRightBar: @Composable () -> Unit = {
        AddButton(
            onClick = addNewLessonAndNav
        )
    }
}