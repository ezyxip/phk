package com.ezyxip.phk.data

import com.ezyxip.phk.ui.models.LessonPresentation

interface DataAdapter {
    fun getLastLessonList(count: Int): List<LessonPresentation>
}