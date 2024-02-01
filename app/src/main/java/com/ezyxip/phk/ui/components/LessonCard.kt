package com.ezyxip.phk.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ezyxip.phk.ui.models.LessonPresentation

@Composable
fun LessonCard(
    modifier: Modifier = Modifier,
    lesson: LessonPresentation = LessonPresentation(),
    onClick: () -> Unit = {}
){
    ElevatedCard (
        modifier = modifier
            .padding(15.dp)
            .clickable { onClick() },
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