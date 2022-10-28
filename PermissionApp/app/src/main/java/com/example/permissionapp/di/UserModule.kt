package com.example.permissionapp.di

import com.example.permissionapp.data.repository.RegisterRepository
import com.example.permissionapp.data.repository.impl.RegisterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn
object UserModule {

    @Provides
    @Singleton
    fun provideRegisterRepository(registerRepositoryImpl: RegisterRepositoryImpl): RegisterRepository=registerRepositoryImpl
}