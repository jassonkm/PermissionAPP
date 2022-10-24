package com.example.permissionapp.data.local.dao

import androidx.room.*
import com.example.permissionapp.data.local.entity.LocationsEntity

interface LocationDao {

    @Query("SELECT * FROM locationsentity WHERE nameLocation=:name")
    suspend fun existsByName(name: String): Boolean

    @Query("SELECT * FROM locationsentity WHERE nameLocation=:name")
    suspend fun findByName(name: String):List<LocationsEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(locationsEntity: LocationsEntity)

    @Delete
    suspend fun deleteLocations(locationsEntity: LocationsEntity)

    @Update
    suspend fun updateLocations(locationsEntity: LocationsEntity)


}