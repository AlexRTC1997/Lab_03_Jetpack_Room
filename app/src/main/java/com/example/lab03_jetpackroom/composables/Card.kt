package com.example.lab03_jetpackroom.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab03_jetpackroom.entities.CourseWithStudents

@Composable
fun Card(courseWithStudents: CourseWithStudents) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(12.dp, 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = courseWithStudents.course.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            courseWithStudents.students.forEach {
                Column {
                    Row {
                        Text(text = "Student ${it.studentId} (", fontStyle = FontStyle.Italic)
                        Text(text = it.name + " ", fontStyle = FontStyle.Italic)
                        Text(text = it.lastname, fontStyle = FontStyle.Italic)
                        Text(text = ")", fontStyle = FontStyle.Italic)
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}