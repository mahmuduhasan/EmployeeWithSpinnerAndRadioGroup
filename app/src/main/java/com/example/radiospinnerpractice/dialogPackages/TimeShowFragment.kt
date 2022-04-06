package com.example.radiospinnerpractice.dialogPackages

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.*

class TimeShowFragment(val callBack : (String) -> Unit) : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val selectTime = Calendar.getInstance()
        val hour = selectTime.get(Calendar.HOUR)
        val minute = selectTime.get(Calendar.MINUTE)

        return TimePickerDialog(requireActivity(), this, hour, minute, false)
    }
    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val setTimeSelected = Calendar.getInstance()
        setTimeSelected.set(0,0,0,p1,p2)
        val timeFormat = SimpleDateFormat("HH:mm a").format(Date(setTimeSelected.timeInMillis))
        callBack(timeFormat)
    }
}