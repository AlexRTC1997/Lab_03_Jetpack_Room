package com.example.lab03_jetpackroom.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab03_jetpackroom.ViewModel.MainViewModel
import com.example.lab03_jetpackroom.entities.CourseEntity
import com.example.lab03_jetpackroom.entities.CourseStudentCrossRef
import com.example.lab03_jetpackroom.entities.StudentEntity
import com.example.lab03_jetpackroom.navigationHost.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun Home(
    viewModel: MainViewModel,
    navController: NavController
) {

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 48.dp, vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        // verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                text = "Jetpack Room",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                text = "Students & Courses",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = ButtonDefaults.buttonElevation(1.dp),
            onClick = {
                fillTables(viewModel, scope)
            },
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Fill Tables",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = ButtonDefaults.buttonElevation(1.dp),
            onClick = { navController.navigate(Destination.ViewList.route) },
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Course with Students",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp
            )
        }
    }
}

fun fillTables(viewModel: MainViewModel, scope: CoroutineScope) {
    val students = ArrayList<StudentEntity>()

    for (i in 1..20) {
        val studentEntity = StudentEntity(studentId = i, name = "Name ", lastname = "LastName $i")
        students.add(studentEntity)
    }

    scope.launch {
        viewModel.insertAllStudents(students)
    }

    for (i in 1..10) {
        val courseEntity = CourseEntity("Course $i")
        val randomNumberStudents = Random.nextInt(1, 6)
        for (j in 1..randomNumberStudents) {
            val studentId = Random.nextInt(1, 21)
            val courseStudentCrossRef = CourseStudentCrossRef(i, studentId)

            scope.launch {
                viewModel.insertCourseStudentsCrossRef(courseStudentCrossRef)
            }
        }

        scope.launch {
            viewModel.insertCourse(courseEntity)
        }
    }

}