package com.example.lab03_jetpackroom.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab03_jetpackroom.ViewModel.MainViewModel
import com.example.lab03_jetpackroom.composables.Card
import com.example.lab03_jetpackroom.entities.CourseWithStudents

@Composable
fun ViewList(
    viewModel: MainViewModel
) {
    //val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.getAllStudentsOfCourse()
    }

    val listCourseWithStudents: List<CourseWithStudents> by viewModel.allStudents.observeAsState(
        initial = listOf()
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(14.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                text = "Courses with Students",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp, 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (listCourseWithStudents.isEmpty()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "No courses registered yet",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 18.sp
                    )
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(all = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listCourseWithStudents) {
                    Card(courseWithStudents = it)
                }
            }
        }
    }
}