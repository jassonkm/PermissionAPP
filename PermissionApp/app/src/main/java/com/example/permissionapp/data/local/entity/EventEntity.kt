package com.example.permissionapp.data.local.entity

import androidx.room.*
import java.util.*

@Entity
data class EventEntity(

    @PrimaryKey
    val idEvent: Int,

    @ColumnInfo(name = "nameEvent")
    val nameEvent: String,

    @ColumnInfo(name="date")
    val date: Date,

    @ColumnInfo(name = "numberAssistants")
    val numberAssistants: String,

    @ColumnInfo(name = "qr")
    val qr: String
)
