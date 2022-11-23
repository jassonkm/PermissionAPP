package com.example.permissionapp.data.remote.payload

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id") val id:Long,
    @SerializedName("email")val email: String,
    @SerializedName("type") val type: String = "Bearer",
    @SerializedName("token") val token: String,
    @SerializedName("roles") val roles: ArrayList<String>
)
