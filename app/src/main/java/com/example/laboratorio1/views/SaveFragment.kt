package com.example.laboratorio1.views

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.laboratorio1.R
import com.example.laboratorio1.databinding.FragmentListBinding
import com.example.laboratorio1.databinding.FragmentSaveBinding
import com.example.laboratorio1.models.Student
import com.example.laboratorio1.viewModels.StudentViewModel

class SaveFragment : Fragment() {

    private lateinit var binding: FragmentSaveBinding
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(inflater, container, false)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        binding.button.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }

    private fun insertDataToDatabase(){
        val firstName = binding.firstName.text.toString()
        val surname = binding.surname.text.toString()
        val age = binding.age.text
        if(inputCheck(firstName, surname, age)){
            val student = Student(0, firstName, surname, Integer.parseInt(age.toString()))
            studentViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Student created", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_saveFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(), "Fill all the fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, surname: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(surname) || age.isEmpty())
    }
}