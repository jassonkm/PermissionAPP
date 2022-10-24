package com.example.permissionapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class EventWithLocation (
    @Embedded
    val eventEntity: EventEntity,
    @Relation(
        parentColumn = "idEvent",
        entityColumn = "idEVentFK"
    )
    val locationsEntity: Set<LocationsEntity>
    )