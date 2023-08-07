package com.example.codecrunch.Activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codecrunch.API.Retrofitclient
import com.example.codecrunch.Adapter.RoomGameAdapter
import com.example.codecrunch.Model.DataItemRoom
import com.example.codecrunch.Model.ResponseRoom
import com.example.codecrunch.Model.Room_Model
import com.example.codecrunch.R
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Room_Game_Activity : AppCompatActivity() {
    lateinit var namaRoom : TextView
    lateinit var jumlahPemain : TextView
    lateinit var masukRoom : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.room_game_activity)
//        namaRoom = findViewById(R.id.tvRoomName)
//        jumlahPemain = findViewById(R.id.tvCurrentPlayers)




        val apiInterface = Retrofitclient.endpoint
        val call = apiInterface.getRoom()

        call.enqueue(object : Callback<ResponseRoom>{
            override fun onResponse(call: Call<ResponseRoom>, response: Response<ResponseRoom>)
            {
                if (response.isSuccessful){
                    val dataroom = response.body()
                    Log.d("TAG","IniDataRoom "+dataroom)


                    val responseRoom = response.body()
                    val roomList: List<DataItemRoom>? = responseRoom?.data

                    // Menampilkan data di TextView jika ada data room
                    if (roomList != null) {
                        if (roomList.isNotEmpty()) {
                            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                            val roomAdapter = RoomGameAdapter(roomList)

                            // Set layout manager dan adapter ke RecyclerView
                            recyclerView.layoutManager = LinearLayoutManager(this@Room_Game_Activity)
                            recyclerView.adapter = roomAdapter
                        } else {
                            Toast.makeText(this@Room_Game_Activity, "Ini Tidak Ada Room", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this@Room_Game_Activity, "Gagal Mendapatkan Data Room", Toast.LENGTH_SHORT).show()
                }
            }



            override fun onFailure(call: Call<ResponseRoom>, t: Throwable) {
                Toast.makeText(this@Room_Game_Activity,"Api Gagal",Toast.LENGTH_SHORT).show()
            }

        })



    }
}