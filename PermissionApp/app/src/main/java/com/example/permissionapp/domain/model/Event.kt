package com.example.permissionapp.domain.model

import java.util.*

data class Event(
    val idEvent: Int,
    val nameEvent:String,
    val dateEvent: Date,
    val numberAssistants: String,
    val qr: String,
    val locations: Set<Locations>
)
