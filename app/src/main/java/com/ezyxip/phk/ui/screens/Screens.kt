package com.ezyxip.phk.ui.screens

enum class Screens (
    private val _path: String,
    val argument: String = ""
) {
    Main("/main"),
    Courses("/course", "courseId"),
    LessonEdit("/lesson/", "lessonId");

    val path get() = "$_path/" + if (argument == "") "" else "{$argument}"

    fun pathWithArg(argValue: String): String {
        return if(argument == "")
            path
        else
            "$_path/$argValue"
    }
}