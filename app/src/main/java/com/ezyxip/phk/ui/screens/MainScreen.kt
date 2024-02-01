package com.ezyxip.phk.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ezyxip.phk.ui.components.LessonCard
import com.ezyxip.phk.ui.components.MenuableScreen
import com.ezyxip.phk.ui.models.LessonPresentation

const val COUNT_OF_LESSONS_ON_MAIN_SCREEN = 10

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navigator: NavHostController,
    getLastLessons: (Int) -> List<LessonPresentation>
){
    MenuableScreen (
        modifier = modifier,
        navigate = {navigator.navigate(it.path)}
    ){
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier.padding(0.dp, 30.dp),
                text = "Последние конспекты",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            LastLessonList(
                modifier,
                onCardClick = {
                    navigator.navigate(ScreenHub.LessonEdit.pathWithArg(it.toString()))
                },
                getLastLessons = getLastLessons
            )
        }
    }
}

@Composable
private fun LastLessonList(
    modifier: Modifier = Modifier,
    onCardClick: (Int) -> Unit = {},
    getLastLessons: (Int) -> List<LessonPresentation>
){
    val lastLessons = getLastLessons(COUNT_OF_LESSONS_ON_MAIN_SCREEN)
    LazyColumn (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(lastLessons){
            LessonCard(modifier, it, onClick = {onCardClick(it.id)})
        }
    }
}