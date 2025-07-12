package com.bbc.bbc_mobile.di

import android.content.Context
import com.bbc.bbc_mobile.data.local.prefrerences.AuthTokenManager
import com.bbc.bbc_mobile.data.remote.api.ApiConfig
import com.bbc.bbc_mobile.data.repo.AuthRepository
import com.bbc.bbc_mobile.data.repo.CatalogRepository

object Injection {
    fun provideAuthRepository(context: Context) : AuthRepository {
        val apiService = ApiConfig.getApiService()
        return AuthRepository(apiService)
    }

    fun provideCatalogRepository(context: Context) : CatalogRepository {
        val apiService = ApiConfig.getApiService()
        return CatalogRepository(apiService)
    }
}