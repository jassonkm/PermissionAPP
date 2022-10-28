package com.example.permissionapp.data.repository.impl


import com.example.permissionapp.di.IoDispatcher
import com.example.permissionapp.data.remote.api.ApiService
import com.example.permissionapp.data.remote.model.RegisterModel
import com.example.permissionapp.data.remote.model.response.RegisterResponse
import com.example.permissionapp.data.repository.RegisterRepository
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RegisterRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) :RegisterRepository{

    override suspend fun registerUser(registerModel: RegisterModel): ApiResponse<RegisterResponse> = withContext(ioDispatcher) {
        apiService.registerUser(registerModel)
    }
}