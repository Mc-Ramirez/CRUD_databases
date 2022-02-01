package com.example.cruddatabases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cruddatabases.databinding.ActivityMainBinding
import com.example.cruddatabases.databinding.ItemStudentBinding
import com.example.cruddatabases.db.Student

class StudentAdapter : ListAdapter<Student, StudentAdapter.ViewHolder>(StudentDiffUtils()){
    inner class ViewHolder (val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStudentBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = getItem(position)
        holder.binding.tvName.text = student.name
        holder.binding.tvLastname.text = student.lastName
        holder.binding.tvEdad.text = student.age
    }
}

class StudentDiffUtils: DiffUtil.ItemCallback<Student>(){
    override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean = oldItem.id == newItem.id
}