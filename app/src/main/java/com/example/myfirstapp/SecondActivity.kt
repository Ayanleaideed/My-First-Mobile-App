package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Set the challenges list in the TextView
        val textViewChallenges = findViewById<TextView>(R.id.textViewChallenges)
        textViewChallenges.text = getChallengesList().trimIndent()

        // Button to return to the main activity
        val buttonMain = findViewById<Button>(R.id.buttonMain)
        buttonMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to return the challenges list as a string
    private fun getChallengesList() = """
        1. Handling Device Fragmentation
        2. Ensuring App Security
        3. Managing Battery Life and Optimization
        4. Designing for User Experience (UX)
        5. Cross-Platform Compatibility
    """
}
