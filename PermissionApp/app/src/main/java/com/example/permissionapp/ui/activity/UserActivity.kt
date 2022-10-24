package com.example.permissionapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.permissionapp.R
import com.example.permissionapp.databinding.ActivityUserBinding
import com.example.permissionapp.ui.fragment.DatePickerFragment
import com.example.permissionapp.ui.fragment.ScannerFragment


class UserActivity : AppCompatActivity(){

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        next()
        openPicker()
        spinner()
    }

    private fun spinner() {
        val typeId=resources.getStringArray(R.array.type_id)
        if (binding.spinTypeId !=null){
            val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,typeId)
            binding.spinTypeId.adapter=adapter
        }
    }

    private fun openPicker() {
        binding.datePicker.setOnClickListener{
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val datePicker=DatePickerFragment({day,month,year -> onDateSelect(day,month, year) })
        datePicker.show(supportFragmentManager,"datePicker")
    }
    fun onDateSelect(day:Int, month: Int, year: Int){
        binding.datePicker.setText("$day/$month/$year")
    }


    fun next(){
        binding.btnNext.setOnClickListener {
            replaceFragment(ScannerFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment){
        binding.fragmentContainer.visibility= View.VISIBLE
        binding.register.visibility=View.GONE
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(com.example.permissionapp.R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}