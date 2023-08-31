package com.example.codecrunch.Activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.codecrunch.API.Retrofitclient
import com.example.codecrunch.Model.HeroResponse
import com.example.codecrunch.Model.PlayersResponse

import com.example.codecrunch.databinding.ScoreActivityBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Scan_Score_Activity : AppCompatActivity() {
    private lateinit var binding: ScoreActivityBinding
    private lateinit var scanner: IntentIntegrator
    var imageplayer1 : String? = null
    var imageplayer2 : String? = "https://media.hitekno.com/thumbs/2022/09/02/30698-one-piece-shanks/730x480-img-30698-one-piece-shanks.jpg"
    var attack1 : Int? = null
    var attack2 : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ScoreActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        scanner = IntentIntegrator(this)
        val nilai = "4"

        val apiInterface = Retrofitclient.endpoint
        val call = apiInterface.getHero(nilai)
        call.enqueue(object : Callback<HeroResponse>{
            override fun onResponse(call: Call<HeroResponse>, response: Response<HeroResponse>) {
//                if (response.isSuccessful){
                    val body = response.body().toString()
                Log.d("MSG","inidia"+body)
                Toast.makeText(this@Scan_Score_Activity, body, Toast.LENGTH_SHORT).show()
//
//                } else {
//                    Toast.makeText(this@Scan_Score_Activity, "teks", Toast.LENGTH_SHORT).show()
//                }
            }

            override fun onFailure(call: Call<HeroResponse>, t: Throwable) {
                Toast.makeText(this@Scan_Score_Activity, "teks api gagal", Toast.LENGTH_SHORT).show()
            }

        })




        binding.buttoncamera.setOnClickListener {
            val cameraPermission = Manifest.permission.CAMERA
            val requestcode = 11

            if (ContextCompat.checkSelfPermission(this, cameraPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(cameraPermission),requestcode)
            }
            else
            {
                startBarcodeScanning()

                }
            }

        binding.ready.setOnClickListener {
            binding.buttoncamera.visibility = View.VISIBLE

        }

        binding.battle.setOnClickListener {
            val intent = Intent (this@Scan_Score_Activity,Battle_Activity::class.java)
            intent.putExtra("imagefile",imageplayer1)
            intent.putExtra("imagefile2",imageplayer2)
            intent.putExtra("atk",attack1)
            intent.putExtra("atk2",attack2)
            startActivity(intent)
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
                Log.d("Tag","hasilbarcode1"+scannedBarcode)

                val pattern = Regex("""(\d+),"([^"]+)"""")
                val matchResult = pattern.find(scannedBarcode)

               val chosenHero = matchResult
                val no = matchResult!!.groupValues[1].toInt()
                var no1 = scannedBarcode[0]
                val no1Int = no1.digitToIntOrNull()
                val ini = 4



                Log.d("Tag","hasilbarcode"+result)
                Log.d("Tag","hasilbarcodeno"+no1)
                Log.d("Tag","hasilbarcodeno"+no1Int)

               Log.d("Tag","hasilbarcodechosen"+chosenHero)

                if (no1Int != null) {
                    performActionBasedOnHero(no1Int)
                }
                Log.d("Tag","hasilbarcode"+ performActionBasedOnHero(no))
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


    private fun performActionBasedOnHero(hero: Int) {






//        val heroname : String
//        heroname = hero
//        if (heroname == "kizaru") {
//
//            val alamat  = "https://assets.pikiran-rakyat.com/crop/0x0:0x0/750x500/photo/2023/07/29/252416054.jpeg"
//            imageplayer1 = alamat
//            val atkhero = 1000
//            val atkhero2 = 5000
//            attack1 = atkhero
//            attack2 = atkhero2
//
//            Glide.with(binding.imageView2.context)
//                .asBitmap()
//                .load(alamat)
//                .into(binding.imageView2)
//        } else {
//            val alamat2  = "https://assets.pikiran-rakyat.com/crop/0x0:0x0/750x500/photo/2023/07/29/252416054.jpeg"
//            imageplayer2 = alamat2
//            val atkhero2 = 5000
//            val atkhero = 1000
//            attack1 = atkhero
//            attack2 = atkhero2
//
//            Glide.with(binding.imageView2.context)
//                .asBitmap()
//                .load(alamat2)
//                .into(binding.imageView2)
//        }

    }


    }
