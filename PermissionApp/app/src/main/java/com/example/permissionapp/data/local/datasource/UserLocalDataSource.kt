package com.example.permissionapp.data.local.datasource

import com.example.permissionapp.data.local.dao.UserDao
import com.example.permissionapp.data.local.entity.UserEntity
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(private val userDao: UserDao) {
    suspend fun saveUsers(userEntity: UserEntity){
        return userDao.saveUser(userEntity)
    }
    suspend fun loadUsernameByEmail(email: String): UserEntity? {
        return userDao.loadUserByEmail(email)

    }
    suspend fun findByEmail(email: String): UserEntity?{
        return userDao.findByEmail(email)
    }
    suspend fun existByIdNumber(number:String):Boolean{
        return userDao.existsByIdNumber(number)
    }
    suspend fun existsByEmail(email: String):Boolean{
        return userDao.existsByEmail(email)
    }
}