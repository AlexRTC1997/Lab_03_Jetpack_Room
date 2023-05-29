package com.example.danp2023room.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.danp2023room.classes.Destination
import com.example.danp2023room.model.Repository
import com.example.danp2023room.views.Courses
import com.example.danp2023room.views.Register
import com.example.danp2023room.views.Relationship
import com.example.danp2023room.views.RoomSample
import com.example.danp2023room.views.Students

@Composable
fun NavigationAppHost(navController: NavHostController, repository: Repository) {
    NavHost(navController = navController, startDestination = Destination.RoomSample.route) {
        composable(route = Destination.RoomSample.route) { RoomSample(repository = repository, navController = navController) }
        composable(route = Destination.Register.route) { Register(navController = navController) }
        composable(route = Destination.Students.route) { Students(navController = navController) }
        composable(route = Destination.Courses.route) { Courses(navController = navController) }
        composable(route = Destination.Relationship.route) { Relationship(navController = navController) }
    }
}