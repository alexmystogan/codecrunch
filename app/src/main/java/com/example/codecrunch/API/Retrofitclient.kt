package com.example.codecrunch.API

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.codecrunch.API.ApiInterface


object Retrofitclient {
    //192.168.22.34
    private const val BASE_URL = "http://192.168.10.49:80/"
    //192.168.110.175



    val endpoint: ApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiInterface::class.java)
    }


}