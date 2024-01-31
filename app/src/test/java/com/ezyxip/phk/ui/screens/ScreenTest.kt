package com.ezyxip.phk.ui.screens

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ScreenTest {

    @Test
    fun getPath() {
        assertEquals("/main", Screen.Main.path)
        assertEquals("/course/{courseId}", Screen.Courses.path)
        assertEquals("/lesson/{lessonId}", Screen.LessonEdit.path)
    }

    @Test
    fun pathWithArg() {
        assertEquals("/main", Screen.Main.pathWithArg("dsa", "123"))
        assertEquals("/course/dsa", Screen.Courses.pathWithArg("dsa", "123"))
        assertEquals("/lesson/123", Screen.LessonEdit.pathWithArg("123", "dsa"))

    }
}