package com.example.permissionapp.data.local.entity

import androidx.room.*
import com.example.permissionapp.domain.model.ERoles

@Entity
data class RolEntity(

    @PrimaryKey
    val idRol: Int,

    @ColumnInfo(name = "nameRole")
    val nameRol:ERoles
)
