package com.bbc.bbc_mobile.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    @SerializedName("id")
    val id: Int,

    @SerializedName("product_name")
    val name: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("description")
    val description: String,
) : Parcelable