package com.bbc.bbc_mobile.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bbc.bbc_mobile.data.Result
import com.bbc.bbc_mobile.data.remote.api.ApiService
import com.bbc.bbc_mobile.data.remote.response.IceCreamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatalogRepository(private val apiService: ApiService) {
    fun  getAllIceCreams(
        token: String
    ) : LiveData<Result<List<IceCreamResponse>>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)
        val bearer = "Bearer " + token
        try {
            val response = apiService.getAllIceCream(token)
            val list = response.body()?.map { iceCream ->
                IceCreamResponse(
                    id = iceCream.id,
                    name = iceCream.name,
                    description = iceCream.description,
                    price = iceCream.price,
                    images = iceCream.images,
                    type = iceCream.type,
                    size = iceCream.size,
                    topping = iceCream.topping,
                    flavors = iceCream.flavors
                )
            } ?: emptyList()
            emit(Result.Success(list))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}