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
    private fun login(){
        binding.btnUser.setOnClickListener{
           goLogin()
        }
    }
    private fun goLogin(){
        val intent= Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}