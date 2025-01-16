package com.example.travelcompanion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateTripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_trip)

        // Find views
        val tripNameEditText = findViewById<EditText>(R.id.et_trip_name)
        val destinationEditText = findViewById<EditText>(R.id.et_destination)
        val startDateEditText = findViewById<EditText>(R.id.et_start_date)
        val endDateEditText = findViewById<EditText>(R.id.et_end_date)
        val saveTripButton = findViewById<Button>(R.id.btn_save_trip)

        // Handle Save Trip button click
        saveTripButton.setOnClickListener {
            // Retrieve input data
            val tripName = tripNameEditText.text.toString()
            val destination = destinationEditText.text.toString()
            val startDate = startDateEditText.text.toString()
            val endDate = endDateEditText.text.toString()

            // Validate inputs
            if (tripName.isNotEmpty() && destination.isNotEmpty() && startDate.isNotEmpty() && endDate.isNotEmpty()) {
                // Pass the data back to the calling activity
                val resultIntent = Intent().apply {
                    putExtra("tripName", tripName)
                    putExtra("destination", destination)
                    putExtra("startDate", startDate)
                    putExtra("endDate", endDate)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish() // Close this activity
            }
        }

    }
}
