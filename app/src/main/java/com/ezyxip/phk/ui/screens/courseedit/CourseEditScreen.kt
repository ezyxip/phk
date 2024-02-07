package com.ezyxip.phk.ui.screens.courseedit

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
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
import com.ezyxip.phk.ui.screens.ScreenHub
import com.ezyxip.phk.ui.screens.courseedit.state.ModeFactory

@Composable
fun CourseEditScreen(
    modifier: Modifier = Modifier,
    args: Map<String, String?>,
    navigator: NavHostController,
    getCourseById: (Int) -> CoursePresentation,
    getLessonsByCourseId: (Int) -> List<LessonPresentation>,
    addNewLesson: (Int) -> Int,
    changeCourseName: (Int, String) -> Unit,
    deleteLesson: (Int) -> Unit
){
    val courseId = args[ScreenHub.CourseEdit.arguments[0]] ?: throw Exception("Не найден courseId")
    val course = getCourseById(courseId.toInt())
    var onDelList by remember {
        mutableStateOf(listOf<Int>())
    }
    val mode = ModeFactory.getMode(
        isListEmpty = onDelList.isEmpty(),
        navToLesson = {id -> navigator.navigate(ScreenHub.LessonEdit.pathWithArg(id.toString()))},
        toggleSelection = {
            if (onDelList.contains(it))
                onDelList = onDelList.filter { e -> e != it }
            else
                onDelList += it
        },
        addNewLessonAndNav = {
            val id = addNewLesson(course.id)
            navigator.navigate(ScreenHub.LessonEdit.pathWithArg(id.toString()))
        },
        deleteCourses = {
            onDelList.forEach{ deleteLesson(it) }
            onDelList = listOf()
        }
    )

    MenuableScreen (
        modifier = modifier,
        title = mode.title,
        navigate = {navigator.navigate(it.path)},
        rightButton = mode.headerRightBar
    ) {
        CourseEditBody(
            modifier = modifier,
            course = course,
            getLessonsByCourseId = getLessonsByCourseId,
            onCardClick = mode.onCardClick,
            onCardPress = mode.onCardPress,
            changeCourseName = changeCourseName,
            isSelected = {id -> onDelList.contains(id)}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CourseEditBody(
    modifier: Modifier = Modifier,
    course: CoursePresentation,
    getLessonsByCourseId: (Int) -> List<LessonPresentation>,
    onCardClick: (Int) -> Unit = {},
    onCardPress: (Int) -> Unit = {},
    changeCourseName: (Int, String) -> Unit,
    isSelected: (Int) -> Boolean
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
            onValueChange = {
                changeCourseName(course.id, it)
                courseTitle = it
            }
        )
        LazyColumn(
            modifier = modifier.fillMaxWidth()
        ){
            items(getLessonsByCourseId(course.id)){
                item ->
                LessonCard(
                    modifier = modifier
                        .combinedClickable (
                            onClick = { onCardClick(item.id) },
                            onLongClick = { onCardPress(item.id) }
                        ),
                    lesson = item,
                    isSelected = isSelected(item.id)
                )
            }
        }
    }
}

