package com.example.codecrunch.Model

data class LoginResponse(
	val result: Result? = null,
	val code: Int? = null,
	val massage: String? = null
)

data class Result(
	val token: String? = null
)

