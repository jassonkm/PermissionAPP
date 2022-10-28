package com.example.permissionapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.permissionapp.R
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.permissionapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding:FragmentLoginBinding
    private lateinit var navController: NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchRegisterFragment(view)
    }

    private fun launchRegisterFragment(view: View) {
        val register = binding.btnCreate

        navController = Navigation.findNavController(view)
        register.setOnClickListener {
            navController.navigate(R.id.registerFragment)
        }
    }
}