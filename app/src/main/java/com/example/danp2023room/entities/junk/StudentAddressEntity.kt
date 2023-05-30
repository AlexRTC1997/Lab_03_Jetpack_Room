package com.example.danp2023room.entities.junk

import androidx.room.Embedded
import androidx.room.Relation
import com.example.danp2023room.entities.StudentEntity

data class StudentAddressEntity(
    @Embedded val studentEntity: StudentEntity,
    @Relation(
        parentColumn = "",
        entityColumn = ""
    )
    val addressEntity: AddressEntity
)