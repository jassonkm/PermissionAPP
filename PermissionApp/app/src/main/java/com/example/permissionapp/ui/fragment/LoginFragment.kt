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
import com.example.permissionapp.ui.viewModel.LoginViewModel
import com.example.permissionapp.utils.MessangeResponse
import com.google.android.material.snackbar.Snackbar
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
        launchScannerFragment(view)
        validFields()
        setObservers()
    }

    private fun launchScannerFragment(view: View) {
        val register = binding.btnCreate

        navController = Navigation.findNavController(view)
        register.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_scannerFragment)
        }
    }
    private fun launchShowFragment(view: View) {
        navController = Navigation.findNavController(view)
        navController.navigate(R.id.action_loginFragment_to_showFragment)
    }

    private fun setObservers() {
        loginViewModel.isLogin.observe(viewLifecycleOwner) { isRegister ->
            if (isRegister) {
                view?.let { launchShowFragment(it) }
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
                view?.let {  Snackbar.make(it,"Error: Usuario o contraseña invalida", Snackbar.LENGTH_SHORT).show()}
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
                    view?.let {  Snackbar.make(it,"Correo invalido", Snackbar.LENGTH_SHORT).show()}
                }
            }else{
                view?.let {  Snackbar.make(it,"Ningún campo puede estar vacío", Snackbar.LENGTH_SHORT).show()}
            }
        }
    }
}