package com.bbc.bbc_mobile.ui

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.bbc.bbc_mobile.data.local.prefrerences.AuthTokenManager
import com.bbc.bbc_mobile.di.Injection

class ViewModelFactory(
    private val context: Context,
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ViewModel::class.java) -> {
                ViewModel(Injection.provideAuthRepository(context), AuthTokenManager(context), Injection.provideCatalogRepository(context)) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class: ${modelClass.name}")
        }
    }
}
