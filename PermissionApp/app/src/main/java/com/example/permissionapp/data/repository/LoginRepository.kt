package com.example.permissionapp.data.repository

import com.example.permissionapp.data.remote.model.LoginModel
import com.example.permissionapp.data.remote.payload.LoginResponse
import com.skydoves.sandwich.ApiResponse

interface LoginRepository {
    suspend fun loginUser(loginModel: LoginModel): ApiResponse<LoginResponse>
}