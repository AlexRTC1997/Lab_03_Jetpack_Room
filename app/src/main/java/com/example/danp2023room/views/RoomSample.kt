package com.example.danp2023room.views

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danp2023room.classes.Destination
import com.example.danp2023room.fillTables
import com.example.danp2023room.model.Repository
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RoomSample(repository: Repository, navController: NavHostController) {
    val tag = "RoomDatabase"
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val fillDataOnClick = {
            fillTables(repository, scope)
        }

        val studentsOnClick: () -> Unit = {
            scope.launch {
                repository.getAllStudents().forEach {
                    Log.d(tag, it.toString())
                }
            }
        }

        val booksOnClick: () -> Unit = {
            scope.launch {
                repository.getAllBooks().forEach {
                    Log.d(tag, it.toString())
                }
            }
        }

        val studentWithBooksOnClick: () -> Unit = {
            scope.launch {
                repository.getStudentWithBooks() .forEach {
                    Log.d(tag, it.toString())
                }
            }
        }

        // TODO: Error
        Spacer(modifier = Modifier.height(10.dp))
        // Button(onClick = fillDataOnClick) {
        Button(onClick = { navController.navigate(Destination.Register.route) }) {
            Text(text = "Fill student & courses tables")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            studentsOnClick()
            navController.navigate(Destination.Students.route)
        }) {
            Text(text = "Show students")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            booksOnClick()
            navController.navigate(Destination.Courses.route)
        }) {
            Text(text = "Show courses")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            studentWithBooksOnClick()
            navController.navigate(Destination.Relationship.route)
        }) {
            Text(text = "Student With Books")
        }
    }
}