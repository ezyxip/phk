package com.ezyxip.phk.ui.screens

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ScreenHubTest {

    @Test
    fun getPath() {
        assertEquals("/main", ScreenHub.Main.path)
        assertEquals("/course/{courseId}", ScreenHub.CourseEdit.path)
        assertEquals("/lesson/{lessonId}", ScreenHub.LessonEdit.path)
    }

    @Test
    fun pathWithArg() {
        assertEquals("/main", ScreenHub.Main.pathWithArg("dsa", "123"))
        assertEquals("/course/dsa", ScreenHub.CourseEdit.pathWithArg("dsa", "123"))
        assertEquals("/lesson/123", ScreenHub.LessonEdit.pathWithArg("123", "dsa"))

    }

    @Test
    fun getEntries() {
        assertEquals(5, ScreenHub.entries.size)
    }
}