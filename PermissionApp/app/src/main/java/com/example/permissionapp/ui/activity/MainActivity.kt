package com.example.permissionapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.permissionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        login()


    }
    fun login(){
        binding.btnAdmin.setOnClickListener{
            goLogin()
        }
        binding.btnUser.setOnClickListener{
           goLogin()
        }
    }
    fun goLogin(){
        val intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}