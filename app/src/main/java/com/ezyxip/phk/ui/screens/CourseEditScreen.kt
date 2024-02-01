package com.ezyxip.phk.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ezyxip.phk.ui.components.AddButton
import com.ezyxip.phk.ui.components.LessonCard
import com.ezyxip.phk.ui.components.MenuableScreen
import com.ezyxip.phk.ui.models.CoursePresentation
import com.ezyxip.phk.ui.models.LessonPresentation

@Composable
fun CourseEditScreen(
    modifier: Modifier = Modifier,
    args: Map<String, String?>,
    navigator: NavHostController,
    getCourseById: (Int) -> CoursePresentation,
    getLessonsByCourseId: (Int) -> List<LessonPresentation>,
){
    val courseId = args[ScreenHub.CourseEdit.arguments[0]]
    if(courseId == null){
        throw Exception("Не найден courseId")
    }

    MenuableScreen (
        modifier = modifier,
        title = "Конспекты",
        navigate = {navigator.navigate(it.path)},
        rightButton = {
            AddButton(
                modifier = modifier,
                onClick = {
                    navigator.navigate(ScreenHub.LessonEdit.pathWithArg("0"))
                }
            )}
    ) {
        CourseEditBody(
            modifier = modifier,
            course = getCourseById(courseId.toInt()),
            getLessonsByCourseId = getLessonsByCourseId,
            toLessonEdit = {
                navigator.navigate(
                    ScreenHub.LessonEdit.pathWithArg(it.toString())
                )
            }
        )
    }
}

@Composable
private fun CourseEditBody(
    modifier: Modifier = Modifier,
    course: CoursePresentation,
    getLessonsByCourseId: (Int) -> List<LessonPresentation>,
    toLessonEdit: (Int) -> Unit
){
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),

    ) {
        var courseTitle by remember{ mutableStateOf(course.name) }
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            value = courseTitle,
            onValueChange = {courseTitle = it}
        )
        LazyColumn(
            modifier = modifier.fillMaxWidth()
        ){
            items(getLessonsByCourseId(course.id)){
                item ->
                LessonCard(
                    modifier = modifier,
                    lesson = item,
                    onClick = {toLessonEdit(item.id)}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseEditBodyPreview(){
    CourseEditBody(
        course = CoursePresentation(),
        getLessonsByCourseId = { listOf(
            LessonPresentation(),
        ) },
        toLessonEdit = {}
    )
}