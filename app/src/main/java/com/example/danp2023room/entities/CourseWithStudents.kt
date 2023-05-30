package com.example.danp2023room.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CourseWithStudents(
    @Embedded val course: Course,
    @Relation(
        parentColumn = "courseId",
        entityColumn = "juniorId",
        associateBy = Junction(CourseStudentCrossRef::class)
    )
    val juniors: List<Student>
)
