package com.example.cruddatabases.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "lastName")
    val lastName : String,
    @ColumnInfo(name = "age")
    val age : Int,
    @ColumnInfo(name = "curso")
    val curso : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null
)
