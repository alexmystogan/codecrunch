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
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.codecrunch.R
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import java.util.Scanner

class Score_Activity : AppCompatActivity() {
    lateinit var buttoncamera : Button
    private lateinit var scanner: IntentIntegrator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_activity)
        buttoncamera=findViewById(R.id.buttoncamera)
        scanner = IntentIntegrator(this)

        buttoncamera.setOnClickListener {
            val cameraPermission = Manifest.permission.CAMERA
            val requestcode = 11

            if (ContextCompat.checkSelfPermission(this, cameraPermission)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(cameraPermission),requestcode)
            }
            else
            {
                startBarcodeScanning()

//                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//                startActivityForResult(cameraIntent,requestcode)


                }
            }

            }
    private fun startBarcodeScanning()
    {
        scanner.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        scanner.setBeepEnabled(false)
        scanner.setCameraId(0)
        scanner.setOrientationLocked(false)
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
                Log.d("Tag","hasilbarcode"+result)
                performActionBasedOnHero(chosenHero)
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
        // Logika untuk menentukan pilihan hero berdasarkan nilai barcode
        // Implementasikan sesuai dengan kebutuhan Anda
        // Misalnya, menggunakan database atau aturan pemetaan tertentu
        // dan mengembalikan nama hero yang sesuai
        return "a";
    }

    private fun performActionBasedOnHero(hero: String) {
        // Lakukan tindakan berdasarkan pilihan hero
        // Misalnya, tampilkan pesan, tampilkan gambar, dll.
    }


    }
