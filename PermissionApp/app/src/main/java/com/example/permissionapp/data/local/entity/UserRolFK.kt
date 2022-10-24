package com.example.permissionapp.data.local.entity

import androidx.room.*


@Entity(primaryKeys = ["id","idRol"])
data class UserRolFK(

    val id:Long,
    val idRol: Int
)
