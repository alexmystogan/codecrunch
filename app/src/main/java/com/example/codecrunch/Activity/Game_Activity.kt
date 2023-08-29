package com.example.codecrunch.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.codecrunch.R

class Game_Activity :AppCompatActivity() {
    lateinit var playtext : TextView
    lateinit var goroom : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        playtext = (findViewById(R.id.playtextbutton))
        goroom = (findViewById(R.id.roomactivity))


        playtext.setOnClickListener {
            val intent = Intent(this@Game_Activity,Scan_Score_Activity::class.java)
            startActivity(intent)
        }
        goroom.setOnClickListener {
            val intent1 = Intent(this@Game_Activity,Room_Game_Activity::class.java)
            startActivity(intent1)
        }
    }
}