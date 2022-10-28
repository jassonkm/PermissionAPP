package com.example.permissionapp.di

import android.content.Context
import androidx.room.Room
import com.example.permissionapp.data.local.PermissionDataBase
import com.example.permissionapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn
object RoomModule {
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context ) =
        Room.databaseBuilder(context, PermissionDataBase::class.java,Constants.DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDatabase(permissionDataBase: PermissionDataBase) = permissionDataBase.userDao()

    @Singleton
    @Provides
    fun provideRolDatabase(permissionDataBase: PermissionDataBase) = permissionDataBase.rolDao()

    @Singleton
    @Provides
    fun provideEventDatabase(permissionDataBase: PermissionDataBase) = permissionDataBase.eventDao()

    @Singleton
    @Provides
    fun provideLocationDatabase(permissionDataBase: PermissionDataBase) = permissionDataBase.locationDao()
}