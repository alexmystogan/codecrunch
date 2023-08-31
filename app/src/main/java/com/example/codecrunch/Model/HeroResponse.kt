package com.example.codecrunch.Model

import com.google.gson.annotations.SerializedName

data class HeroResponse(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("data")
	val data: List<DataItemHero?>? = null,
)

data class DataItemHero(

	@field:SerializedName("hero_name")
	val heroName: String? = null,

	@field:SerializedName("elemen")
	val elemen: String? = null,

	@field:SerializedName("Image_hero")
	val imageHero: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("ATK_PSK")
	val aTKPSK: Int? = null,

	@field:SerializedName("heroid")
	val heroid: Int? = null,

	@field:SerializedName("health")
	val health: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("token")
	val token: Any? = null
)
