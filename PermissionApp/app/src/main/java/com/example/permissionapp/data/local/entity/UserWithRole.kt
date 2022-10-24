package com.example.permissionapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithRole(
    @Embedded
    val user:UserEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "idRol",
        associateBy = Junction(UserRolFK::class))
    val rolEntity: Set<RolEntity>
)
