package com.example.cruddatabases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.cruddatabases.databinding.ActivityMainBinding
import com.example.cruddatabases.db.Student
import com.example.cruddatabases.db.StudentDB

class MainActivity : AppCompatActivity() {
    private lateinit var db:StudentDB
    //impletar el binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //impletar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(applicationContext, StudentDB::class.java, "Estudiantes-Database").allowMainThreadQueries().build()

        db.studentDao().addStudent(Student("sergio", "rivera", 21, "DAMP"))
        val student = db.studentDao().findAllStudent()
    }
}