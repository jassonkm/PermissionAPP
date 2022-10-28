package com.example.permissionapp.data.remote.api

import com.example.permissionapp.data.remote.model.RegisterModel
import com.example.permissionapp.data.remote.model.response.RegisterResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/register/")
    suspend fun registerUser(@Body registerModel: RegisterModel): ApiResponse<RegisterResponse>
}