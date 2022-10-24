package com.example.permissionapp.data.local.dao

import androidx.room.Query
import com.example.permissionapp.data.local.entity.RolEntity
import com.example.permissionapp.domain.model.ERoles

interface RoleDao {

    @Query("SELECT * FROM RolEntity WHERE nameRole=:name")
    suspend fun findByName(name: RolEntity): RolEntity?

}