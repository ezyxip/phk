package com.ezyxip.phk.ui.screens.courselist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ezyxip.phk.ui.components.MenuableScreen
import com.ezyxip.phk.ui.models.CoursePresentation
import com.ezyxip.phk.ui.screens.ScreenHub
import com.ezyxip.phk.ui.screens.courselist.state.ModeBuilder

@Composable
fun CourseListScreen(
    modifier: Modifier = Modifier,
    navigator: NavHostController,
    getCourseList: () -> List<CoursePresentation>,
    addNewCourse: () -> Int,
    deleteCourse: (Int) -> Unit
){
    var courseDelList by remember {
        mutableStateOf(listOf<Int>())
    }

    val state = ModeBuilder(
        navigateToEditScreen = {
            id -> navigator.navigate(ScreenHub.CourseEdit.pathWithArg(id.toString()))
        },
        selectCourse = {id -> courseDelList += id},
        addNewCourse = addNewCourse,
        deleteCourses = {
            courseDelList.forEach {e -> deleteCourse(e)}
            courseDelList = listOf()
        },
        listOfSelectedCards = courseDelList
    )

    MenuableScreen (
        modifier = modifier,
        title = state.title,
        navigate = {navigator.navigate(it.path)},
        rightButton = state.headerRightBar
    ){
        Column {
            CourseList(
                courses = getCourseList(),
                onCardClick = state.onCardClick,
                onCardPress = state.onCardPress,
                isSelected = {course -> courseDelList.contains(course.id)}
            )
        }
    }
}

@Composable
fun CourseList(
    modifier: Modifier = Modifier,
    courses: List<CoursePresentation> = listOf(),
    onCardClick: (Int) -> Unit = {},
    onCardPress: (Int) -> Unit,
    isSelected: (CoursePresentation) -> Boolean
){
    Column {
        for (course in courses){
            CourseCard(
                modifier = modifier,
                course = course,
                onClick = {onCardClick(course.id)},
                onPress = {onCardPress(course.id)},
                isSelected = {isSelected(course)}
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CourseCard(
    modifier: Modifier = Modifier,
    course: CoursePresentation = CoursePresentation(),
    onClick: () -> Unit = {},
    onPress: () -> Unit = {},
    isSelected: () -> Boolean = {false}
){
    val colors = if (isSelected())
        CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            contentColor = MaterialTheme.colorScheme.inversePrimary
        )
    else
        CardDefaults.cardColors()


    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .combinedClickable(
                onClick = onClick,
                onLongClick = onPress
            ),
        colors = colors,
        elevation = CardDefaults.cardElevation(6.dp)
    ){
        Text(
            modifier = modifier
                .padding(10.dp),
            text = course.name,
            fontSize = 23.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CourseCardPreview(){
    CourseCard()
}
