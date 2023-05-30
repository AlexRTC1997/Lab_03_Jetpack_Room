package com.example.danp2023room.entities

import androidx.room.Entity

@Entity(primaryKeys = ["courseId", "juniorId"])
data class CourseStudentCrossRef(
    val courseId: Int,
    val juniorId: Int
)
