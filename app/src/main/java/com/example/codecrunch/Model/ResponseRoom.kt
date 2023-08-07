package com.example.codecrunch.Model

import com.google.gson.annotations.SerializedName

data class ResponseRoom(

	@field:SerializedName("data")
	val data: List<DataItemRoom>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataItemRoom(

	@field:SerializedName("room_ID")
	val roomID: Int? = null,

	@field:SerializedName("P2_nickname")
	val p2Nickname: String? = null,

	@field:SerializedName("Status_Ready")
	val statusReady: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("Match_Time")
	val matchTime: String? = null,

	@field:SerializedName("Max_Player")
	val maxPlayer: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("ANY")
	val aNY: String? = null,

	@field:SerializedName("Status_Ready2")
	val statusReady2: String? = null,

	@field:SerializedName("WIN")
	val wIN: Int? = null,

	@field:SerializedName("P1_nickname")
	val p1Nickname: String? = null
)
