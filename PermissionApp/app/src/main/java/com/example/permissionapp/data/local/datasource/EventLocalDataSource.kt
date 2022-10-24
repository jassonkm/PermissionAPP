package com.example.permissionapp.data.local.datasource

import com.example.permissionapp.data.local.dao.EventDao
import com.example.permissionapp.data.local.entity.EventEntity
import javax.inject.Inject

class EventLocalDataSource @Inject constructor(private val eventDao: EventDao) {
    suspend fun saveEvent(eventEntity: EventEntity){
        return eventDao.saveEvent(eventEntity)
    }
    suspend fun getAllEvent():List<EventEntity>{
        return eventDao.getAllEvent()
    }

    suspend fun findByName(name:String):List<EventEntity>{
        return eventDao.findByname(name)
    }
    suspend fun findById(id:Int):EventEntity?{
        return eventDao.findById(id)
    }
    suspend fun findBynAssistants(assistants: String):List<EventEntity>{
        return eventDao.findBynAssistants(assistants)
    }
}