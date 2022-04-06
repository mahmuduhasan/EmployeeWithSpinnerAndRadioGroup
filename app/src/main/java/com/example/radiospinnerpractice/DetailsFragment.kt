package com.example.radiospinnerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.radiospinnerpractice.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding : FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container, false)
        val bundle = arguments
        val name = bundle?.getString("name")
        val role = bundle?.getString("role")
        val city = bundle?.getString("city")
        val phone = bundle?.getString("phone")
        val address = bundle?.getString("address")

        binding.nameView.text = name
        binding.cityView.text = city
        binding.roleView.text = role
        binding.phoneView.text = phone
        binding.addressView.text = address
        return binding.root
    }

}