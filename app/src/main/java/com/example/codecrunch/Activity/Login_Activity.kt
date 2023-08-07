package com.example.codecrunch.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.codecrunch.API.Retrofitclient
import com.example.codecrunch.Model.LoginResponse
import com.example.codecrunch.Model.PlayersResponse
import com.example.codecrunch.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login_Activity : AppCompatActivity() {
    lateinit var loginteks: TextView
    lateinit var password: TextView
    lateinit var loginbutton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        loginteks = findViewById(R.id.username)
        password = findViewById(R.id.passwordcode)
        loginbutton = findViewById(R.id.loginbutton)

        loginbutton.setOnClickListener {
            val usernameteks = loginteks.text.toString()
            val passwordteks = password.text.toString()
            val apiInterface = Retrofitclient.endpoint
            val call = apiInterface.login(usernameteks,passwordteks)

            call.enqueue( object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val teks = response.body().toString()
                        Toast.makeText(this@Login_Activity, teks, Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@Login_Activity,Game_Activity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@Login_Activity, "gagal", Toast.LENGTH_SHORT).show()
                    }


                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@Login_Activity, "fail", Toast.LENGTH_SHORT).show()

                }


            })
        }
    }
}





