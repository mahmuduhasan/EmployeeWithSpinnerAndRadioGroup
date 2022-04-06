package com.example.radiospinnerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.example.radiospinnerpractice.databinding.FragmentDataBinding
import com.example.radiospinnerpractice.dialogPackages.DateShowFragment
import com.example.radiospinnerpractice.dialogPackages.TimeShowFragment

class DataFragment : Fragment() {
    private lateinit var employeeBinding : FragmentDataBinding
    private var city : String = "Dhaka"
    private var position : String = "Manager"
    private var gender : String = "Male"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        employeeBinding = FragmentDataBinding.inflate(inflater,container,false)
        spinnerDataBinder()
        genderRBSelector()

        employeeBinding.joiningDateButton.setOnClickListener {
            DateShowFragment{
                employeeBinding.dateShowTV.text = it
            }.show(childFragmentManager,null)
        }

        employeeBinding.joiningTimeButton.setOnClickListener {
            TimeShowFragment{
                employeeBinding.dateTimeTV.text = it
            }.show(childFragmentManager,null)
        }

        return employeeBinding.root
    }

    private fun genderRBSelector() {
        employeeBinding.genderRG.setOnCheckedChangeListener { radioGroup, i ->
            val selectedRB : RadioButton = radioGroup.findViewById(i)
            gender = selectedRB.text.toString()
        }
    }

    private fun spinnerDataBinder() {
        val cityAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            cityList
        )

        val positionAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            positionList
        )

        employeeBinding.branchSpinner.adapter = cityAdapter
        employeeBinding.roleSpinner.adapter = positionAdapter

        employeeBinding.branchSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    city = p0?.getItemAtPosition(p2).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

        employeeBinding.roleSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    position = p0?.getItemAtPosition(p2).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
    }

}

val cityList = listOf("Dhaka","Barishal","Rangpur","Khulna","Rajshahi","Chittagong","Chandpur","Noakhali","Bagerhat","Magura")
val positionList = listOf("Manager","Project Head","FrontEnd Developer","Backend Developer","UI/UX Designer","Creative Developer","Business Analyst")