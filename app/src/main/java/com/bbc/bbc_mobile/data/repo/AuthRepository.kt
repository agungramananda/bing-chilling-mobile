package com.bbc.bbc_mobile.data.repo

import com.bbc.bbc_mobile.data.model.RegisterRequest
import com.bbc.bbc_mobile.data.remote.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.bbc.bbc_mobile.data.Result
import com.bbc.bbc_mobile.data.model.LoginRequest
import com.bbc.bbc_mobile.data.remote.response.LoginResponse

class AuthRepository (private val apiService: ApiService, ) {
    suspend fun registerUser(
        name: String,
        email: String,
        password: String
    ) : Result<Boolean> {
        val request = RegisterRequest(
            name, email, password
        )
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.registerUser(request)
                val statusCode = response.code()

                when (statusCode) {
                    200 -> {
                       Result.Success(true)
                    }
                    201 -> {
                        Result.Success(true)
                    }
                    400 -> {
                        Result.Error("email already registered")
                    }
                    500 -> {
                        Result.Error("internal server error")
                    }
                    else -> {
                        Result.Error(response.errorBody().toString())
                    }
                }
            } catch (e: Exception) {
                Result.Error(e.message.toString())
            }
        }
    }

    suspend fun login(
        email: String,
        password: String
    ) : Result<LoginResponse> {
        val request = LoginRequest(
            email, password
        )
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.login(request)
                if (response.isSuccessful){
                    response.body()?.let {
                        Result.Success(it)
                    } ?: Result.Error("empty response")
                } else {
                    Result.Error("Error")
                }
            } catch (e: Exception){
                Result.Error(e.message.toString())
            }
        }
    }
}