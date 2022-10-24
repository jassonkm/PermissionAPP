package com.example.permissionapp.data.local.entity

import androidx.room.*
import java.util.*


@Entity
data class UserEntity(

    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "lastName")
    val lastName: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "typeId")
    val typeId:String,

    @ColumnInfo(name = "idNumber")
    val idNumber: String,

    @ColumnInfo(name="birthday")
    val birthday: Date
)
