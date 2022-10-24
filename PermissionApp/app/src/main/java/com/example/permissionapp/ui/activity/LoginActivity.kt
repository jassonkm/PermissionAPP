package com.example.permissionapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.permissionapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user()
        home()
    }

    private fun home() {
        binding.btnLogin.setOnClickListener{
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun user(){
        binding.btnCreate.setOnClickListener{
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
    }
}