package com.bbc.bbc_mobile.data.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String
)