package com.example.cruddatabases.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("select * from student")
    fun findAllStudent(): List<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addStudent(student: Student)
}