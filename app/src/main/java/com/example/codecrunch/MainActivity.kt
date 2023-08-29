package com.example.codecrunch


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.TextView
import android.widget.Toast

import com.example.codecrunch.API.ApiInterface
import com.example.codecrunch.API.Retrofitclient
import com.example.codecrunch.Activity.Login_Activity
import com.example.codecrunch.Model.Daftar_List_Model
import com.example.codecrunch.Model.PlayersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.codecrunch.R
import com.example.codecrunch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var connTextview: TextView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiInterface = Retrofitclient.endpoint
        val call = apiInterface.getPlayers()

        call.enqueue(object : Callback<PlayersResponse>{
            override fun onResponse(
                call: Call<PlayersResponse>,
                response: Response<PlayersResponse>
            ) {
                if(response.isSuccessful){
              //     val playerhasil = response.body()
              //      val players = playerhasil?.data
              //      val playername = players?.get(0)?.playername
//                    connTextview.text = playername.toString()

                    val intent = Intent(this@MainActivity, Login_Activity::class.java)
                    startActivity(intent)

                    // Jangan lupa untuk mengakhiri MainActivity agar tidak tampil di stack kembali saat menekan tombol "Back"
                    finish()

                    Log.d("tag", "data success ${response.body()?.data}")
                } else {
                    Log.d("tag", "data failed ${response.body()?.data}")
                    connTextview.text = "Tidak Ada Index Player"
                }
            }

            override fun onFailure(call: Call<PlayersResponse>, t: Throwable) {
                Log.d("tag", "data onFailure${t.message}")
                connTextview.text = "Fail"
            }

        })
    }



}






