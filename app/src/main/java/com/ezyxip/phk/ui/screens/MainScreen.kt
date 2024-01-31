package com.ezyxip.phk.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ezyxip.phk.ui.components.MenuableScreen
import com.ezyxip.phk.ui.models.LessonPresentation
import com.ezyxip.phk.ui.models.UIModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
){
    MenuableScreen (
        modifier = modifier
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
            LastLessonList(modifier)
        }
    }
}

@Composable
private fun LastLessonList(
    modifier: Modifier = Modifier
){
    val lastLessons = UIModel.getLastLessons()
    LazyColumn (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(lastLessons){
            LessonCard(modifier, it)
        }
    }
}

@Composable
fun LessonCard(
    modifier: Modifier = Modifier,
    lesson: LessonPresentation = LessonPresentation()
){
    ElevatedCard (
        modifier = modifier
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column (
            modifier = modifier
                .padding(20.dp, 10.dp)
                .fillMaxWidth()
        ){
            Text(
                modifier = modifier,
                text = lesson.title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = modifier.padding(0.dp, 5.dp),
                text = lesson.course,
                fontSize = 18.sp,
            )
            Text(
                modifier = modifier.padding(0.dp, 10.dp),
                text = lesson.date)
        }
    }
}

@Preview
@Composable
fun LessonCardPreview(){
    LessonCard()
}