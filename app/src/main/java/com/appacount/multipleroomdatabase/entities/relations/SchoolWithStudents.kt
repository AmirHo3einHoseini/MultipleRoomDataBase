package com.appacount.multipleroomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.appacount.multipleroomdatabase.entities.School
import com.appacount.multipleroomdatabase.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
