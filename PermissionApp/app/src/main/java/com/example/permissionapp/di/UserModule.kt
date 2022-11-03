package com.example.permissionapp.di

import com.example.permissionapp.data.repository.LoginRepository
import com.example.permissionapp.data.repository.RegisterRepository
import com.example.permissionapp.data.repository.impl.LoginRepositoryImpl
import com.example.permissionapp.data.repository.impl.RegisterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideRegisterRepository(registerRepositoryImpl: RegisterRepositoryImpl): RegisterRepository=registerRepositoryImpl

    @Provides
    @Singleton
    fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository=loginRepositoryImpl
}