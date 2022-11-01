package com.example.permissionapp.utils

import org.json.JSONObject

object MessangeResponse {
    fun getErrorMessage(message: String): String {
        val response = JSONObject(message)
        return response.getString("error")
    }
}