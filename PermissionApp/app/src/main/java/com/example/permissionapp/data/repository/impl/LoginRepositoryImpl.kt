package com.example.permissionapp.data.repository.impl

import com.example.permissionapp.data.remote.api.ApiService
import com.example.permissionapp.data.remote.model.LoginModel
import com.example.permissionapp.data.remote.payload.LoginResponse
import com.example.permissionapp.data.repository.LoginRepository
import com.example.permissionapp.di.IoDispatcher
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
):LoginRepository {
    override suspend fun loginUser(loginModel: LoginModel): ApiResponse<LoginResponse> = withContext(ioDispatcher) {
        apiService.loginUser(loginModel)
    }



}