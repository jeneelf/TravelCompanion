package com.example.travelcompanion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TripDashboardActivity : AppCompatActivity() {

    private lateinit var tripsAdapter: TripsAdapter
    private val tripsList = mutableListOf<Trip>() // List to store trips dynamically

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_dashboard)

        val tripsRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_trips)
        val fabAddTrip = findViewById<FloatingActionButton>(R.id.fab_add_trip)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set up RecyclerView
        tripsAdapter = TripsAdapter(tripsList)
        tripsRecyclerView.layoutManager = LinearLayoutManager(this)
        tripsRecyclerView.adapter = tripsAdapter

        // Initialize with mock data
        tripsList.addAll(getMockTrips())
        tripsAdapter.notifyDataSetChanged()

        // Handle Floating Action Button click to open CreateTripActivity
        fabAddTrip.setOnClickListener {
            val intent = Intent(this, CreateTripActivity::class.java)
            startActivityForResult(intent, 1) // Request code 1 for identifying the result
        }

        // Bottom Navigation handling
        bottomNavigation.selectedItemId = R.id.nav_home
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    // Handle result from CreateTripActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val tripName = data?.getStringExtra("tripName")
            val destination = data?.getStringExtra("destination")
            val startDate = data?.getStringExtra("startDate")
            val endDate = data?.getStringExtra("endDate")

            if (tripName != null && destination != null && startDate != null && endDate != null) {
                tripsList.add(Trip(tripName, destination, startDate, endDate, R.drawable.sample_image))
                tripsAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun getMockTrips(): List<Trip> {
        return listOf(
            Trip("Trip to Paris", "Paris", "June 5, 2024", "June 10, 2024", R.drawable.paris_image),
            Trip("Weekend Getaway", "Beach", "July 1, 2024", "July 8, 2024", R.drawable.beach_image)
        )
    }

    inner class TripsAdapter(private val trips: List<Trip>) :
        RecyclerView.Adapter<TripsAdapter.TripViewHolder>() {

        inner class TripViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tripName: TextView = view.findViewById(R.id.trip_title)
            val tripDate: TextView = view.findViewById(R.id.trip_date)
            val tripImage: ImageView = view.findViewById(R.id.trip_image) // ImageView for the trip image
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trip, parent, false)
            return TripViewHolder(view)
        }

        override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
            val trip = trips[position]
            holder.tripName.text = trip.tripName
            holder.tripDate.text = "${trip.destination} (${trip.startDate} to ${trip.endDate})"

            // Set the image using the image resource ID
            holder.tripImage.setImageResource(trip.imageResId)

            // Handle item click to navigate to Itinerary
            holder.itemView.setOnClickListener {
                val intent = Intent(this@TripDashboardActivity, ItineraryActivity::class.java)
                intent.putExtra("trip_name", trip.tripName)
                intent.putExtra("destination", trip.destination)
                startActivity(intent)
            }
        }

        override fun getItemCount(): Int = trips.size
    }
}
