package com.ezyxip.phk.ui.screens.courselist.state

import androidx.compose.runtime.Composable
import com.ezyxip.phk.ui.components.DeleteButton

class SelectedMode (
    selectCourse: (Int) -> Unit,
    deleteCourses: () -> Unit,
) : CourseListScreenState {

    override val onCardClick: (Int) -> Unit = selectCourse
    override val onCardPress: (Int) -> Unit = selectCourse
    override val title: String = "Выделение..."
    override val headerRightBar: @Composable () -> Unit = {
        DeleteButton{
            deleteCourses()
        }
    }

}