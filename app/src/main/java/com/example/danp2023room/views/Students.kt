package com.example.danp2023room.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.danp2023room.classes.Destination

@Composable
fun Students(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Student")
        Button(onClick = { navController.navigate(Destination.RoomSample.route) }) {
            Text(text = "Go Home")
        }
    }
}