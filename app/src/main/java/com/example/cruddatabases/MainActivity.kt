package com.example.cruddatabases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.cruddatabases.databinding.ActivityMainBinding
import com.example.cruddatabases.db.Student
import com.example.cruddatabases.db.StudentDB

class MainActivity : AppCompatActivity() {
    private lateinit var db:StudentDB
    //impletar el binding
    private lateinit var binding: ActivityMainBinding
    private val adapter = StudentAdapter({
        Toast.makeText(this, "student: $it", Toast.LENGTH_SHORT).show()
    }, {
        db.studentDao().delete(it)
        refresh()
    })

    private fun refresh() {
        val student = db.studentDao().findAllStudent()
        adapter.submitList(student)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //impletar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStudentList.layoutManager = LinearLayoutManager(this)
        binding.rvStudentList.adapter = adapter
        db = Room.databaseBuilder(applicationContext, StudentDB::class.java, "Estudiantes-Database").allowMainThreadQueries().build()

        //db.studentDao().addStudent(Student("sergio", "rivera", "21", "DAMP"))
        val student = db.studentDao().findAllStudent()
        refresh()

        adapter.submitList(student)

        binding.btnAnadir.setOnClickListener{
            addStudent()
        }
    }

    private fun addStudent() {
        val name = binding.txtNombre.text.toString()
        val lastname = binding.txtApellido.text.toString()
        val edad = binding.txtEdad.text.toString()

        val student = Student(name, lastname, edad, "DAMP")
        db.studentDao().addStudent(student)

        refresh()
    }


}