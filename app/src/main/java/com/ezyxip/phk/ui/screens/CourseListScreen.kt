package com.ezyxip.phk.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ezyxip.phk.ui.components.AddButton
import com.ezyxip.phk.ui.components.MenuableScreen
import com.ezyxip.phk.ui.models.CoursePresentation
import com.ezyxip.phk.ui.models.UIModel

@Composable
fun CourseLIstScreen(
    modifier: Modifier = Modifier,
    navigator: NavHostController
){
    MenuableScreen (
        modifier = modifier,
        title = "Курсы",
        navigate = {navigator.navigate(it.path)},
        rightButton = {
            AddButton{
                navigator.navigate(
                    ScreenHub.CourseEdit.pathWithArg("0")
                )
            }
        }
    ){
        Column {
            CourseList(
                courses = UIModel.getCourses(),
                onCardClick = {
                    navigator.navigate(
                        ScreenHub.CourseEdit.pathWithArg(it.toString())
                    )
                }
            )
        }
    }
}

@Composable
fun CourseList(
    modifier: Modifier = Modifier,
    courses: List<CoursePresentation> = listOf(),
    onCardClick: (Int) -> Unit = {}
){
    Column {
        for (course in courses){
            CourseCard(
                modifier = modifier,
                course = course,
                onClick = {onCardClick(course.id)}
            )
        }
    }
}

@Composable
fun CourseCard(
    modifier: Modifier = Modifier,
    course: CoursePresentation = CoursePresentation(),
    onClick: () -> Unit = {}
){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick() },
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
