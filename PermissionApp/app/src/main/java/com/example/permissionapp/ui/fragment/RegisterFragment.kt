package com.example.permissionapp.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.permissionapp.R
import com.example.permissionapp.data.remote.model.RegisterModel
import com.example.permissionapp.databinding.FragmentRegisterBinding
import com.example.permissionapp.ui.viewModel.RegisterViewModel
import com.example.permissionapp.utils.Constants


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var navController: NavController
    private lateinit var register: RegisterModel

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
        setAdmin()
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
    private fun setAdmin(){
        binding.btnAdmin.setOnClickListener{
            AdminDialogFragment(
                onSubmitClickListener = { password->
                    if (password.equals(Constants.PASSWORD_ADMIN)){
                        binding.showAdmin.visibility=View.VISIBLE
                        binding.layoutBtnAdmin.visibility=View.GONE
                    }
                    else{
                        Toast.makeText(context, "Clave admin incorrecto", Toast.LENGTH_SHORT).show()
                    }
                }
            ).show(parentFragmentManager,"Dialog")
        }

    }
    private fun validFields(){
        binding.btnNext.setOnClickListener{
            val name: String=binding.edtName.text.toString()
            val lastName:String=binding.edtLastname.text.toString()
            val email:String=binding.edtEmail.text.toString()
            val password:String=binding.edtPassword.text.toString()
            val passwordValidation: String=binding.edtPassword2.text.toString()
            val typeId:String=binding.spinTypeId.adapter.toString()
        }
    }


}