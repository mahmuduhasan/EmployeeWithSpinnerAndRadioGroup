package com.example.radiospinnerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.radiospinnerpractice.databinding.FragmentEmployeeBinding

class EmployeeFragment : Fragment() {

    private lateinit var binding: FragmentEmployeeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployeeBinding.inflate(inflater,container,false)
        val adapter = EmployeeAdapter()
        binding.employeeRecycleView.layoutManager = LinearLayoutManager(requireActivity())
        binding.employeeRecycleView.adapter = adapter
        adapter.submitList(employeeList)

        binding.addNew.setOnClickListener {
            findNavController().navigate(R.id.action_employeeFragment_to_dataFragment)
        }
        return binding.root
    }

}