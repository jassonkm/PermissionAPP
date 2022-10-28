package com.example.permissionapp.data.repository

import com.example.permissionapp.data.remote.model.RegisterModel
import com.example.permissionapp.data.remote.model.response.RegisterResponse
import com.skydoves.sandwich.ApiResponse

interface RegisterRepository {
    suspend fun registerUser(registerModel: RegisterModel):ApiResponse<RegisterResponse>
}