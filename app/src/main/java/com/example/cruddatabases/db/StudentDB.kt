package com.example.cruddatabases.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class StudentDB : RoomDatabase(){
    abstract fun studentDao() : StudentDao
}