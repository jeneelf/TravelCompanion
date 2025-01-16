package com.example.travelcompanion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeText: TextView = findViewById(R.id.welcomeText)
        val startButton: Button = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            // Log to check if button click
            Log.d("MainActivity", "Start button clicked!")

            // Navigate to TripDashboardActivity
            val intent = Intent(this, TripDashboardActivity::class.java)
            startActivity(intent)
        }

    }
}
