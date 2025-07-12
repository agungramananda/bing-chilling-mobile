package com.bbc.bbc_mobile.data.remote.api

import com.bbc.bbc_mobile.data.model.LoginRequest
import com.bbc.bbc_mobile.data.model.RegisterRequest
import com.bbc.bbc_mobile.data.remote.response.IceCreamResponse
import com.bbc.bbc_mobile.data.remote.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/auth/register")
    suspend fun  registerUser(
        @Body request: RegisterRequest
    ): Response<Unit>

    @POST("/auth/login")
    suspend fun  login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("/catalog/ice-creams")
    suspend fun getAllIceCream(
        @Header("Authorization") token: String
    ): Response<List<IceCreamResponse>>
}