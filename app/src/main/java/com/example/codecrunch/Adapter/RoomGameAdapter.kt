package com.example.codecrunch.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.codecrunch.Activity.Game_Activity
import com.example.codecrunch.Activity.Score_Activity
import com.example.codecrunch.Model.DataItemRoom
import com.example.codecrunch.R

class RoomGameAdapter(private val roomList: List<DataItemRoom>?) : RecyclerView.Adapter<RoomGameAdapter.RoomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        // Inflate layout item_room.xml
        val view = LayoutInflater.from(parent.context).inflate(R.layout.room_data, parent, false)
        return RoomViewHolder(view)

    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = roomList?.get(position)
        holder.tvRoomName.text = "Room " + room?.roomID.toString()
        holder.tvCurrentPlayers.text = "Jumlah Pemain Saat Ini: " + room?.maxPlayer.toString()
    }

    override fun getItemCount(): Int {
        return roomList?.size ?: 0
    }

    // ViewHolder class
    class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRoomName: TextView = itemView.findViewById(R.id.tvRoomName)
        val tvCurrentPlayers: TextView = itemView.findViewById(R.id.tvCurrentPlayers)
        private val context: Context = itemView.context

        // Tambahkan ViewHolder sesuai dengan layout item_room.xml Anda
        val btnMasukRoom: Button = itemView.findViewById(R.id.buttonmasukRoom)

        init {
            // Tambahkan logika penanganan klik tombol di sini
            btnMasukRoom.setOnClickListener {
                val intent = Intent(context, Score_Activity::class.java)
                context.startActivity(intent)
            }
        }
    }

    interface OnRoomClickListener {
        fun onRoomClick(room: DataItemRoom)
    }
}
