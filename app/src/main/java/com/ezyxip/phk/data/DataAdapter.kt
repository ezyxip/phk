package com.ezyxip.phk.data

import com.ezyxip.phk.ui.models.CoursePresentation
import com.ezyxip.phk.ui.models.LessonPresentation

interface DataAdapter {
    fun getLastLessonList(count: Int): List<LessonPresentation>
    fun getCourseById(id: Int): CoursePresentation
    fun getLessonsByCourseId(courseId: Int): List<LessonPresentation>
    fun getCourseList(): List<CoursePresentation>
    fun addNewCourse(): Int
    fun addNewLesson(courseId: Int): Int
    fun changeCourseName(courseId: Int, newName: String)
    fun deleteCourse(courseId: Int)
    fun deleteLesson(lessonId: Int)
    fun getLessonById(lessonId: Int): LessonPresentation
}