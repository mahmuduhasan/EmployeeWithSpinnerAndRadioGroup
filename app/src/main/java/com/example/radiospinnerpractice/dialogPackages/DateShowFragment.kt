package com.example.radiospinnerpractice.dialogPackages

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.*

class DateShowFragment(val callBack : (String) -> Unit) : DialogFragment(), DatePickerDialog.OnDateSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val selectedDate = Calendar.getInstance()
        val year = selectedDate.get(Calendar.YEAR)
        val month = selectedDate.get(Calendar.MONTH)
        val day = selectedDate.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), this, year, month, day)
    }
    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val setDateSelect = Calendar.getInstance()
        setDateSelect.set(p1,p2,p3)
        val formatedDate = SimpleDateFormat("dd/MM/yyyy").format(Date(setDateSelect.timeInMillis))
        callBack(formatedDate)
    }

}