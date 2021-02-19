package com.example.laboratorio1.views

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio1.databinding.RecyclerViewItemBinding
import com.example.laboratorio1.models.Student

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var studentList = emptyList<Student>()

    class MyViewHolder(val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        with(holder){
            binding.field1.text = currentItem.firstName.toString()
            binding.field2.text = currentItem.surname.toString()
            binding.field3.text = currentItem.age.toString()
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
    fun setData(student: List<Student>){
        this.studentList = studentList
        notifyDataSetChanged()
    }
}