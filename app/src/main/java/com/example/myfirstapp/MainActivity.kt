package com.example.myfirstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Display full name and student ID
        val textViewName = findViewById<TextView>(R.id.textViewName)
        textViewName.text = "Ayanle Aideed\n1185242"

        // Button to start second activity explicitly
        val buttonExplicit = findViewById<Button>(R.id.buttonExplicit)
        buttonExplicit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Button to start second activity implicitly (example opens a website)
        val buttonImplicit = findViewById<Button>(R.id.buttonImplicit)
        buttonImplicit.setOnClickListener {
            val NDSUSite = "https://www.ndsu.edu/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(NDSUSite))
            startActivity(intent)
        }
    }
}
