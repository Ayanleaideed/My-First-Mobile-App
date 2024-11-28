package com.example.myfirstapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display full name and student ID
        val textViewName = findViewById<TextView>(R.id.textViewName)
        textViewName.text = "Ayanle Aideed\n1185242"

        // Button to start SecondActivity explicitly
        val buttonExplicit = findViewById<Button>(R.id.buttonExplicit)
        buttonExplicit.setOnClickListener {
            // Check if the custom permission is granted
            if (ContextCompat.checkSelfPermission(this, "com.example.myfirstapp.MSE412")
                == PackageManager.PERMISSION_GRANTED) {
                // Permission already granted
                Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
                startSecondActivity()
            } else {
                // Request the custom permission
                Toast.makeText(this, "Requesting permission", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf("com.example.myfirstapp.MSE412"),
                    PERMISSION_REQUEST_CODE
                )
            }
        }

        // Button to start a website (example of implicit intent)
        val buttonImplicit = findViewById<Button>(R.id.buttonImplicit)
        buttonImplicit.setOnClickListener {
            val NDSUSite = "https://www.ndsu.edu/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(NDSUSite))
            startActivity(intent)
        }

        // Button to start ImageActivity for image capture and display
        val buttonViewImageActivity = findViewById<Button>(R.id.button_view_image_activity)
        buttonViewImageActivity.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show()
                startSecondActivity()
            } else {
                // Permission denied
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
