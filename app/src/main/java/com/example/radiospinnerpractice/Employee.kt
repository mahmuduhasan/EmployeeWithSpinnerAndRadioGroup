package com.example.radiospinnerpractice

data class Employee(
    val id: Long,
    val name: String,
    val role: String,
    val city: String,
    val joiningDate: String,
    val joiningTime: String,
    val gender: String
)

val employeeList = mutableListOf<Employee>()
