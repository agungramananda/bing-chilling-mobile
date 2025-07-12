package com.bbc.bbc_mobile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bbc.bbc_mobile.data.Result
import com.bbc.bbc_mobile.data.local.prefrerences.AuthTokenManager
import com.bbc.bbc_mobile.data.model.RegisterRequest
import com.bbc.bbc_mobile.data.remote.response.LoginResponse
import com.bbc.bbc_mobile.data.repo.AuthRepository
import com.bbc.bbc_mobile.data.repo.CatalogRepository
import kotlinx.coroutines.launch

class ViewModel (private val authRepository: AuthRepository, private val pref: AuthTokenManager, private val catalogRepository: CatalogRepository): ViewModel() {
    private val _register = MutableLiveData<Result<Boolean>>()
    val register : LiveData<Result<Boolean>> get() = _register

    private val _login = MutableLiveData<Result<LoginResponse>>()
    val login : LiveData<Result<LoginResponse>> get() = _login

    fun getToken(): LiveData<String?> {
        return pref.getToken().asLiveData()
    }

    fun saveToken(token: String) {
        viewModelScope.launch {
            pref.saveToken(token)
        }
    }

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            _register.value = Result.Loading
            _register.value = authRepository.registerUser(name, email, password)
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _login.value = Result.Loading
            _login.value = authRepository.login(email, password)
        }
    }

    fun getIceCreams() = catalogRepository.getAllIceCreams(token = getToken().value.toString())
}