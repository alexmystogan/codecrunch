package com.example.codecrunch.Model

data class Room_Model(
	val data: Data? = null,
	val success: Boolean? = null,
	val message: String? = null
)

data class Data(
	val roomID: Int? = null,
	val statusReady: String? = null,
	val updatedAt: String? = null,
	val playerID: String? = null,
	val matchTime: String? = null,
	val maxPlayer: String? = null,
	val createdAt: String? = null
)

