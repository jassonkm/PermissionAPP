package com.example.permissionapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import com.example.permissionapp.R
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.permissionapp.data.remote.model.LoginModel
import com.example.permissionapp.databinding.FragmentLoginBinding
import com.example.permissionapp.ui.activity.HomeActivity
import com.example.permissionapp.ui.viewModel.LoginViewModel
import com.example.permissionapp.utils.MessangeResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding:FragmentLoginBinding
    private lateinit var navController: NavController
    private lateinit var login: LoginModel

    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchRegisterFragment(view)
        validFields()
        setObservers()
    }

    private fun launchRegisterFragment(view: View) {
        val register = binding.btnCreate

        navController = Navigation.findNavController(view)
        register.setOnClickListener {
            navController.navigate(R.id.registerFragment)
        }
    }
    private fun goHomeView(){
        val intent=Intent(context,HomeActivity::class.java)
        startActivity(intent)
    }
    private fun setObservers() {
        loginViewModel.isLogin.observe(viewLifecycleOwner) { isRegister ->
            if (isRegister) {
                 goHomeView()
                Toast.makeText(context, "Sesion iniciada con exito", Toast.LENGTH_SHORT).show()
            }
        }
        loginViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.linearLayoutLoading.isVisible = isLoading
            } else {
                binding.linearLayoutLoading.isVisible = false
            }
        }
        loginViewModel.error.observe(viewLifecycleOwner) { error ->
            if (error.isNotEmpty())
            {
                Toast.makeText(
                    context,
                    "Error: Usuario o contraseña invalids" ,
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{
                Toast.makeText(
                    context,
                    "Error: " + MessangeResponse.getErrorMessage(error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        loginViewModel.connectivity.observe(viewLifecycleOwner) { connectivity ->
            Toast.makeText(context, "" + connectivity, Toast.LENGTH_SHORT).show()
        }
    }
    private fun validFields(){
        binding.btnLogin.setOnClickListener{
            val email:String = binding.edtEmailLogin.text.toString()
            val password:String = binding.edtPasswordLogin.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    login = LoginModel(email, password)
                    lifecycleScope.launch {
                        loginViewModel.onLoginUser(login)
                    }
                }else{
                    Toast.makeText(context, "Correo invalido", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context, "Ningun campo puede estar vacio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}