@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.danp2023room.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp2023room.classes.Destination

@Composable
fun Register(navController: NavHostController) {
    var studentId by remember { mutableStateOf("") }
    var studentFullName by remember { mutableStateOf("") }

    var courseId by remember { mutableStateOf("") }
    var courseName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // [STUDENT]
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Register Student",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "ID: ") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { studentId = it },
                singleLine = true,
                value = studentId
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "FullName: ") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { studentFullName = it },
                singleLine = true,
                value = studentFullName
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Destination.RoomSample.route) }) {
                Text(text = "Save Student")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // [COURSES]
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Register Course",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "ID: ") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { courseId = it },
                singleLine = true,
                value = courseId
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Course name: ") },
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { courseName = it },
                singleLine = true,
                value = courseName
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Destination.RoomSample.route) }) {
                Text(text = "Save Course")
            }
        }
    }
}