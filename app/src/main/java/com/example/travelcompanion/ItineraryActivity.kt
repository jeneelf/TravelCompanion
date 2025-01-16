package com.example.travelcompanion

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ItineraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itinerary)

        // Get the trip details passed from the TripDashboardActivity
        val tripName = intent.getStringExtra("trip_name")
        val destination = intent.getStringExtra("destination")

        // Set up the UI components
        val parisImageView = findViewById<ImageView>(R.id.iv_paris_image)
        val itineraryTitleTextView = findViewById<TextView>(R.id.tv_trip_name)
        val destinationAndDateTextView = findViewById<TextView>(R.id.tv_destination_and_date)

        // Set the Paris image (replace with an actual Paris image resource if needed)
        parisImageView.setImageResource(R.drawable.paris_image)

        // Set the trip name and destination
        itineraryTitleTextView.text = tripName
        destinationAndDateTextView.text = "Destination: $destination\nDates: June 5, 2024 - June 10, 2024" // Example dates

        // Set up Day 1 itinerary
        val day1TitleTextView = findViewById<TextView>(R.id.tv_day_1_title)
        val day1MorningTextView = findViewById<TextView>(R.id.tv_day_1_morning)
        val day1AfternoonTextView = findViewById<TextView>(R.id.tv_day_1_afternoon)
        val day1EveningTextView = findViewById<TextView>(R.id.tv_day_1_evening)

        day1TitleTextView.text = "Day 1: Arrival in Paris"
        day1MorningTextView.text = "• Morning: Arrival at Charles de Gaulle Airport, transfer to hotel."
        day1AfternoonTextView.text = "• Afternoon: Explore Montmartre, visit Sacré-Cœur Basilica."
        day1EveningTextView.text = "• Evening: Dinner at a Parisian bistro."

        // Set up Day 2 itinerary
        val day2TitleTextView = findViewById<TextView>(R.id.tv_day_2_title)
        val day2MorningTextView = findViewById<TextView>(R.id.tv_day_2_morning)
        val day2AfternoonTextView = findViewById<TextView>(R.id.tv_day_2_afternoon)
        val day2EveningTextView = findViewById<TextView>(R.id.tv_day_2_evening)

        day2TitleTextView.text = "Day 2: Iconic Paris Landmarks"
        day2MorningTextView.text = "• Morning: Guided tour of the Eiffel Tower, including the summit."
        day2AfternoonTextView.text = "• Afternoon: Lunch at a café with Eiffel Tower views."
        day2EveningTextView.text = "• Evening: Seine River Cruise. Admire illuminated landmarks and enjoy a scenic dinner."

        // Set up Day 3 itinerary
        val day3TitleTextView = findViewById<TextView>(R.id.tv_day_3_title)
        val day3MorningTextView = findViewById<TextView>(R.id.tv_day_3_morning)
        val day3AfternoonTextView = findViewById<TextView>(R.id.tv_day_3_afternoon)
        val day3EveningTextView = findViewById<TextView>(R.id.tv_day_3_evening)

        day3TitleTextView.text = "Day 3: Cultural Immersion and Departure"
        day3MorningTextView.text = "• Morning: Visit Notre-Dame Cathedral and explore Île de la Cité."
        day3AfternoonTextView.text = "• Afternoon: Free time for shopping at Champs-Élysées or visiting the Musée d'Orsay."
        day3EveningTextView.text = "• Evening: Transfer to the airport for return flight or enjoy a farewell meal."

        // Set up attendees' profile pictures
        setAttendeesProfilePictures()

        // Back button functionality
        val backButton: ImageView = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setAttendeesProfilePictures() {
        // Assign profile pictures for attendees (replace with actual profile pictures as needed)
        val attendee1 = findViewById<ImageView>(R.id.attendee1)
        val attendee2 = findViewById<ImageView>(R.id.attendee2)
        val attendee3 = findViewById<ImageView>(R.id.attendee3)

        attendee1.setImageResource(R.drawable.profile_pic_1)
        attendee2.setImageResource(R.drawable.profile_pic_2)
        attendee3.setImageResource(R.drawable.profile_pic_3)
    }
}
