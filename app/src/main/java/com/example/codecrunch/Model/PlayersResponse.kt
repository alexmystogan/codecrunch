package com.example.codecrunch.Model

import com.google.gson.annotations.SerializedName

data class PlayersResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("level")
	val level: Int? = null,

	@field:SerializedName("jobs")
	val jobs: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("playername")
	val playername: String? = null,

	@field:SerializedName("playerid")
	val playerid: Int? = null,

	@field:SerializedName("token")
	val token: Any? = null
)
