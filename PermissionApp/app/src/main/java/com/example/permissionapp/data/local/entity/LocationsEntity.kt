package com.example.permissionapp.data.local.entity

import androidx.room.*


@Entity
 data class LocationsEntity(

    @PrimaryKey
    val idLocations: Int,

    @ColumnInfo(name = "nameLocation")
    val nameLocation: String,

    @ColumnInfo(name="capacity")
    val capacity: Int,

    @ColumnInfo(name = "idEventFK")
    val idEventFK: Int
 )