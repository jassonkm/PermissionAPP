package com.example.permissionapp.ui.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment(val listener:(day:Int, month:Int, year:Int)-> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return calendarShow()
    }
    private fun calendarShow(): DatePickerDialog{
        val calendar:Calendar=Calendar.getInstance()
        val day: Int=calendar.get(Calendar.DAY_OF_MONTH)
        val month: Int=calendar.get(Calendar.MONTH)
        val year:Int=calendar.get(Calendar.YEAR)
        val picker= DatePickerDialog(activity as Context,this,year,month,day)
        picker.datePicker.maxDate=calendar.timeInMillis
        return picker
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {
        listener(dayofMonth,month, year)
    }
}