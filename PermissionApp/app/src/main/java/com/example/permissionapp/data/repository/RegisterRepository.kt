package com.example.permissionapp.data.repository

import com.example.permissionapp.data.remote.model.RegisterModel
import com.skydoves.sandwich.ApiResponse

interface RegisterRepository {
    suspend fun registerUser(registerModel: RegisterModel):ApiResponse<RegisterModel>
}