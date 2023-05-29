package com.example.danp2023room.classes

sealed class Destination(val title: String, val route: String) {
    object RoomSample : Destination("RoomSample", "roomSample")
    object Register : Destination("Register","register")
    object Students : Destination("Students","students")
    object Courses : Destination("Courses","courses")
    object Relationship : Destination("Relationship", "relationship")
}