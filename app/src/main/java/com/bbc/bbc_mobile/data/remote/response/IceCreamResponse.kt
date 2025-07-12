package com.bbc.bbc_mobile.data.remote.response

import com.google.gson.annotations.SerializedName

data class IceCreamResponse(

	@field:SerializedName("flavors")
	val flavors: List<FlavorsItem?>? = null,

	@field:SerializedName("images")
	val images: String? = null,

	@field:SerializedName("size")
	val size: Size? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: Type? = null,

	@field:SerializedName("topping")
	val topping: Topping? = null
)

data class Type(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class FlavorsItem(

	@field:SerializedName("flavor")
	val flavor: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Size(

	@field:SerializedName("size")
	val size: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Topping(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("topping")
	val topping: String? = null
)
