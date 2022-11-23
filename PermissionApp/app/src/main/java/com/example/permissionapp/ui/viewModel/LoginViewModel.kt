package com.example.permissionapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.permissionapp.data.remote.model.LoginModel
import com.example.permissionapp.data.repository.LoginRepository
import com.example.permissionapp.utils.Dynamics
import com.example.permissionapp.utils.NetworkHelper
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val networkHelper: NetworkHelper
) :ViewModel(){
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean>
        get() = _isLogin

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _connectivity = MutableLiveData<String>()
    val connectivity: LiveData<String>
        get() = _connectivity

    fun onLoginUser(loginModel: LoginModel){
        viewModelScope.launch {
            _isLoading.postValue(true)
            if (networkHelper.isNetworkConnected()){
                loginRepository.loginUser(loginModel)
                    .onSuccess {
                        _isLoading.postValue(false)
                        Dynamics.ROL= response.body()?.roles.toString()
                        Log.e( "onLoginUser: ",""+Dynamics.ROL )
                        _isLogin.postValue(true)
                    }.onError {
                        _isLoading.postValue(false)
                        _error.postValue(response.errorBody()!!.string())
                        Log.e("reponse", "getErrorMessage: "+response.errorBody()!!.string())
                    }.onFailure {
                        _isLoading.postValue(false)
                    }
            }else{
                _isLoading.postValue(false)
                _connectivity.postValue("Sin conexion a internet")
            }
        }
    }
}