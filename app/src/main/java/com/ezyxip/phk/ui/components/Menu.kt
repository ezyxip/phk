package com.ezyxip.phk.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezyxip.phk.ui.models.MenuItem
import com.ezyxip.phk.ui.models.UIModel

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    items: List<MenuItem> = listOf(MenuItem())
){
    Column (
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp)
            .fillMaxHeight()
    ) {
        for(i in items){
            TextButton(onClick = i.navigate) {
                Icon(imageVector = i.icon, contentDescription = null)
                Spacer(modifier = modifier.padding(5.dp))
                Text(i.name)
            }
        }
    }
}

@Preview
@Composable
fun MenuPreview(){
    Menu(items = UIModel.getMenuItems())
}