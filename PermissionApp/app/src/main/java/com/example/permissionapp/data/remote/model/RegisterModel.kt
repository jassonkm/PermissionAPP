package com.example.permissionapp.data.remote.model


import com.example.permissionapp.domain.model.Role
import com.google.gson.annotations.SerializedName
import java.util.*

data class RegisterModel(
    @SerializedName("nombre")val name: String,
    @SerializedName("apellido")val lastName: String,
    @SerializedName("email")val email: String,
    @SerializedName("password")val password: String,
    @SerializedName("typeid") val typeId: String,
    @SerializedName("idNum")val idNumber: String,
    @SerializedName("birthday")val birthday: String,
    @SerializedName("role")val role: List<String>
)
