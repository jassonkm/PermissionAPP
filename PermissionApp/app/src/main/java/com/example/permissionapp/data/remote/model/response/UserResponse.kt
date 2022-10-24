package com.example.permissionapp.data.remote.model.response

import com.example.permissionapp.data.remote.model.UserModel
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("results") val response: List<UserModel>
)
