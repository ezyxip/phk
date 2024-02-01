package com.ezyxip.phk.ui.screens

import androidx.compose.material3.Text
import com.ezyxip.phk.data.DataAdapter
import com.ezyxip.phk.ui.models.LessonPresentation

object ScreenHub {

//    private val logger = ScreenHub::class.qualifiedName?.let { Logger.getLogger(it) }!!

    var dataSource: DataAdapter = DefaultDataSource()

    val Main = Screen(
    "/main",
    screenContent = {
        _, navigator ->
        MainScreen(
            navigator = navigator,
            getLastLessons = { dataSource.getLastLessonList(it) }
        ) }
    )

    val CourseEdit = Screen(
    "/course",
    listOf("courseId"),
    screenContent = { args, nav -> CourseEditScreen(args = args, navigator = nav) }
    )

    val LessonEdit = Screen(
    "/lesson",
    listOf("lessonId"),
    screenContent = { _, _ -> Text("Lesson page") }
    )

    val CourseList = Screen(
    "/courseList",
    screenContent = { _, navigator -> CourseLIstScreen(navigator = navigator) }
    )

    val Default = Screen(
        "/default",
        screenContent = { _, _ -> Text(text = "DefaultPage") }
    );

    val entries: List<Screen>
    init{

        val res = mutableListOf<Screen>()
        val a = this::class
        for (i in a.members){
            if (i.returnType.toString() == Screen::class.qualifiedName) {
                res.add(i.call(this) as Screen)
            }
        }

        entries = res.toList()
    }
}

class DefaultDataSource: DataAdapter{
    override fun getLastLessonList(count: Int): List<LessonPresentation> {
        return List (count) { LessonPresentation() }
    }

}