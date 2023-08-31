package com.example.codecrunch.API

import com.example.codecrunch.Model.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @GET("players")
   fun getPlayers(): Call<PlayersResponse>


    @GET("hero/{Id}")
    fun getHero(
        @Path("Id") ID:String
    ): Call<HeroResponse>

    @GET("showroom")
    fun getRoom(): Call<ResponseRoom>

    @FormUrlEncoded
   @POST("login")
   fun login(
        @Field("email/username") username : String ,
        @Field("password") password :String
    ) : Call<LoginResponse>

   @FormUrlEncoded
   @POST("createroom")
   fun loadroom(
       @Field("statusReady") sts : String ,
       @Field("playerID") plyrid :String,
       @Field("matchTime") matchtime : String ,
    @Field("maxPlayer") maxplyr :String
   ) : Call<Room_Model>

}