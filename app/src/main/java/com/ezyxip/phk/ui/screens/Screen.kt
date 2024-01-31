package com.ezyxip.phk.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kotlin.Exception

enum class Screen (
    private val _path: String,
    val arguments: List<String> = listOf(),
    val screenContent: @Composable (
        Map<String, String?>,
        NavHostController
    ) -> Unit = { _, _ -> Text(text = _path) }
) {

    Main("/main", screenContent = {
                                  _, navigator ->MainScreen(navigator = navigator)
    }),
    Courses("/course", listOf("courseId"), screenContent = {_, _ -> Text("Course page")}),
    LessonEdit("/lesson", listOf("lessonId"), screenContent = {_, _ -> Text("Lesson page")});

    val path: String
        get(){
            var res = _path
            for (arg in arguments){
                res += "/{$arg}"
            }

            return res
        }

    fun pathWithArg(vararg argValue: String): String {
        var res = _path
        try {
            for(i in 0..<arguments.size){
                res += "/${argValue[i]}"
            }
        } catch (e: Exception){
            throw Exception("Слишком мало параметров")
        }


        return res
    }
}