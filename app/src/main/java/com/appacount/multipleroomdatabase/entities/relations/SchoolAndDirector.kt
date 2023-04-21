package com.appacount.multipleroomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.appacount.multipleroomdatabase.entities.Director
import com.appacount.multipleroomdatabase.entities.School

/*
this relation refer to one-to_one relation

 */
data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
