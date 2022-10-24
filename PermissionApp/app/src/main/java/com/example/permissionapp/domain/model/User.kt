package com.example.permissionapp.domain.model

import java.util.*

data class User(
    val id: Long,
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
    val typeId: String,
    val idNumber: String,
    val birthday: Date,
    val state: Boolean,
    val role: Set<Role>
)
