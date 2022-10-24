package com.example.permissionapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.permissionapp.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity WHERE email=:email")
    suspend fun findByEmail(email: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(userEntity: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE idNumber=:number")
    suspend fun existsByIdNumber(number: String):Boolean

    @Query("SELECT * FROM UserEntity WHERE email=:email")
    suspend fun existsByEmail(email: String): Boolean

    @Query("SELECT * FROM userentity WHERE email=:email")
    suspend fun loadUserByEmail(email: String): UserEntity?

}