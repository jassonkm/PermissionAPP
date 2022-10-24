package com.example.permissionapp.data.local.datasource

import com.example.permissionapp.data.local.dao.RoleDao
import com.example.permissionapp.data.local.entity.RolEntity
import javax.inject.Inject

class RolLocalDataSource  @Inject constructor(private val roleDao: RoleDao){
    suspend fun findByName(name:RolEntity):RolEntity?{
        return roleDao.findByName(name)
    }
}