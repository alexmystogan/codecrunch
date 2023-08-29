package com.example.codecrunch.Activity

import android.Manifest
import android.Manifest.permission.CAMERA
import android.Manifest.permission_group.CAMERA
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.hardware.SensorPrivacyManager.Sensors.CAMERA
import android.media.MediaRecorder.VideoSource.CAMERA
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.View.inflate
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

import com.example.codecrunch.R
import com.example.codecrunch.databinding.BattleActivityBinding
import com.example.codecrunch.databinding.ScoreActivityBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import java.util.Scanner

class Battle_Activity : AppCompatActivity() {
    private lateinit var binding: BattleActivityBinding
    private lateinit var scanner: IntentIntegrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BattleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alamat = intent.getStringExtra("imagefile")
        val alamat2 = intent.getStringExtra("imagefile2")
        val atk = intent.getIntExtra("atk",0)
        val atk2 = intent.getIntExtra("atk2",0)




        Log.d("TAG","INIGAMBAR"+ alamat +"!!!!"+alamat2)
        Log.d("TAG","INIATK"+ atk +"!!!!"+atk)



        scanner = IntentIntegrator(this)




        binding.buttoncamera.setOnClickListener {

            val atkbaru = atk?.toInt()
           val atkbaru2 = atk2?.toInt()
Log.d("TAG","IniAtak"+atkbaru)
            Log.d("TAG","IniAtak"+atkbaru2)
            Log.d("TAG","IniAtak"+atk?.toInt())
            Log.d("TAG","IniAtak"+atk2?.toInt())

            if(atkbaru!! > atkbaru2!!){
                Toast.makeText(this,"Player 1 Menang",Toast.LENGTH_SHORT).show()


            }
            else if (atkbaru!! < atkbaru2!!){
                Toast.makeText(this,"Player 2 Menang",Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(this,"Hasil Imbang",Toast.LENGTH_SHORT).show()
            }

            }

        binding.ready.setOnClickListener {
            binding.buttoncamera.visibility = View.VISIBLE
            Glide.with(binding.imageView2.context)
                .asBitmap()
                .load(alamat)
                .into(binding.imageView2)


            Glide.with(binding.imageView3.context)
                .asBitmap()
                .load(alamat2)
                .into(binding.imageView3)

        }

            }
    private fun startBarcodeScanning()
    {
        scanner.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        scanner.setBeepEnabled(false)
        scanner.setCameraId(0)
        scanner.setOrientationLocked(true)
        scanner.initiateScan()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if (result != null)
        {
            if (result.contents != null)
            {
                val scannedBarcode = result.contents
                val chosenHero = determineHero(scannedBarcode)
                var no: String? = null
                var nama: String? = null





              //  Log.d("Tag","hasilbarcode"+result)
                Log.d("Tag","hasilbarcode"+no)
                Log.d("Tag","hasilbarcode"+nama)
                Log.d("Tag","hasilbarcode"+chosenHero)

                performActionBasedOnHero(chosenHero)
                Log.d("Tag","hasilbarcode"+ performActionBasedOnHero(chosenHero))
            }
            else
            {

            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
    private fun determineHero(barcode: String): String {
        val no : String
        val nama : String
        val pattern = Regex("""(\d+),"([^"]+)"""")
        val matchResult = pattern.find(barcode)

        if (matchResult != null) {
             no = matchResult.groupValues[1].toString()
        }
        if (matchResult != null) {
             nama = matchResult.groupValues[2].toString()
        }

        return matchResult!!.groupValues[2].toString();
    }

    private fun performActionBasedOnHero(hero: String) {
        val heroname : String
        heroname = hero

    }


    }
