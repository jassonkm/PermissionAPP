package com.example.permissionapp.data.remote.model.response

import com.example.permissionapp.data.remote.model.LoginModel
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("results") val response: List<LoginModel>
)
