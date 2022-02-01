package com.example.cruddatabases.db

import androidx.room.*

@Dao
interface StudentDao {
    @Query("select * from student")
    fun findAllStudent(): List<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addStudent(student: Student)

    @Delete
    fun delete(student : Student)
}