package com.ezyxip.phk.ui.screens.courseedit.state

class ModeFactory {
    companion object{
        fun getMode(
            isListEmpty: Boolean,
            navToLesson: (Int) -> Unit,
            toggleSelection: (Int) -> Unit,
            addNewLessonAndNav: () -> Unit,
            deleteCourses: () -> Unit
        ): CourseEditState {
            return if (isListEmpty){
                NormalMode(navToLesson, toggleSelection, addNewLessonAndNav)
            } else {
                SelectedMode(toggleSelection, deleteCourses)
            }
        }
    }
}