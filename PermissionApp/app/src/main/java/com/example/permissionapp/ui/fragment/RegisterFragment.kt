package com.example.permissionapp.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.permissionapp.R
import com.example.permissionapp.databinding.FragmentRegisterBinding
import com.example.permissionapp.ui.viewModel.RegisterViewModel


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var navController: NavController
    //private lateinit var register: Register

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openPicker()
        spinner()
        //goBackLogin(view)
        launchScannerFragment(view)
    }
    private fun spinner() {
        val typeId=resources.getStringArray(R.array.type_id)
        if (binding.spinTypeId !=null){
            val adapter= ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,typeId)
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
        datePicker.show(parentFragmentManager,"datePicker")
    }
    fun onDateSelect(day:Int, month: Int, year: Int){
        binding.datePicker.setText("$day/$month/$year")
    }
    private fun launchScannerFragment(view: View) {
        val goScanner = binding.btnNext
        navController = Navigation.findNavController(view)
        goScanner.setOnClickListener{
            navController.navigate(R.id.scannerFragment)
        }
        
    }
    private fun goBackLogin(view: View) {
        val backLogin = binding.btnNext

        navController = Navigation.findNavController(view)
        backLogin.setOnClickListener {
            navController.navigate(R.id.loginFragment)
        }
    }

}