package com.example.permissionapp.ui.activity.ui.showQR

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShowQRViewModel : ViewModel() {
    private val _text= MutableLiveData<String>().apply {
        value="This is show fragment"
    }
    val text: LiveData<String> =_text
}