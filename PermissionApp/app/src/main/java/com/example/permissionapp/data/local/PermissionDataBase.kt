package com.example.permissionapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.permissionapp.data.local.dao.EventDao
import com.example.permissionapp.data.local.dao.LocationDao
import com.example.permissionapp.data.local.entity.*


@Database(entities = [
    EventEntity::class,
    LocationsEntity::class],
    version = 1)
abstract class PermissionDataBase: RoomDatabase(){


    abstract fun eventDao():EventDao
    abstract fun locationDao():LocationDao

    companion object{
        private var INSTANCE: PermissionDataBase ?=null

        fun getDatabase(context: Context):PermissionDataBase{
            INSTANCE = INSTANCE?: Room.databaseBuilder(
                context.applicationContext,
                PermissionDataBase::class.java,
                "Permision table"
            ).build()
            return INSTANCE!!
        }
        fun destroyInstance(){
            INSTANCE=null
        }
    }


}