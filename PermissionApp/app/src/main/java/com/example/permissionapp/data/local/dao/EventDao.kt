package com.example.permissionapp.data.local.dao

import androidx.room.*
import com.example.permissionapp.data.local.entity.EventEntity

interface EventDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEvent(eventEntity: EventEntity)

    @Query("SELECT * FROM evententity")
    suspend fun getAllEvent():List<EventEntity>

    @Query("SELECT * FROM evententity WHERE nameEvent=:name")
    suspend fun findByname(name: String): List<EventEntity>


    @Query("SELECT * FROM evententity WHERE idEvent=:id")
    suspend fun findById(id: Int): EventEntity?

    @Query("SELECT * FROM evententity WHERE numberAssistants=:assistants")
    suspend fun findBynAssistants(assistants: String):List<EventEntity>

    @Delete
    suspend fun deleteById(eventEntity: EventEntity)

    @Update
    suspend fun updateById(eventEntity: EventEntity)
}