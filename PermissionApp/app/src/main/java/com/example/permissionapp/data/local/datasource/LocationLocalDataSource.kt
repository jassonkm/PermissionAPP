package com.example.permissionapp.data.local.datasource

import com.example.permissionapp.data.local.dao.LocationDao
import com.example.permissionapp.data.local.entity.LocationsEntity
import javax.inject.Inject

class LocationLocalDataSource @Inject constructor(private val locationDao: LocationDao) {

    suspend fun saveLocations(locationsEntity: LocationsEntity){
        return locationDao.saveLocations(locationsEntity)
    }
    suspend fun existsByName(name:String):Boolean{
        return locationDao.existsByName(name)
    }
    suspend fun findByName(name: String):List<LocationsEntity>?{
        return locationDao.findByName(name)
    }
}