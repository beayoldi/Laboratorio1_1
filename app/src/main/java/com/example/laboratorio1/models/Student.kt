package com.example.laboratorio1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val surname: String,
    val age: Int
)
