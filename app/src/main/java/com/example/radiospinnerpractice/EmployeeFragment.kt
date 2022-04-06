package com.example.radiospinnerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
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
        val adapter = EmployeeAdapter(::onReceiveEmployee)
        binding.employeeRecycleView.layoutManager = LinearLayoutManager(requireActivity())
        binding.employeeRecycleView.adapter = adapter
        adapter.submitList(employeeList)
        binding.addNew.setOnClickListener {
            findNavController().navigate(R.id.action_employeeFragment_to_dataFragment)
        }
        return binding.root
    }

    fun onReceiveEmployee(employee: Employee){
        val bundle = Bundle().apply {
            putString("name", employee.name)
            putString("role", employee.role)
            putString("city", employee.city)
            putString("phone",employee.phone)
            putString("address",employee.address)
        }

        findNavController().navigate(R.id.action_employeeFragment_to_detailsFragment2, bundle)
    }

}