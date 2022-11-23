package com.example.permissionapp.data.remote.api

import com.example.permissionapp.data.remote.model.LoginModel
import com.example.permissionapp.data.remote.model.RegisterModel
import com.example.permissionapp.data.remote.payload.LoginResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/register/")
    suspend fun registerUser(@Body registerModel: RegisterModel): ApiResponse<RegisterModel>

    @POST("/auth/login")
    suspend fun loginUser(@Body loginModel: LoginModel): ApiResponse<LoginResponse>
}