package com.example.travelcompanion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val userNameTextView: TextView = findViewById(R.id.user_name)
        val userEmailTextView: TextView = findViewById(R.id.user_email)
        val profileImageView: ImageView = findViewById(R.id.profile_image)

        val editProfileButton: Button = findViewById(R.id.btn_edit_profile)
        val logoutButton: Button = findViewById(R.id.btn_logout)

        // Set up mock data for now
        userNameTextView.text = "John Doe"
        userEmailTextView.text = "john.doe@example.com"

        // Navigate to Edit Profile screen
        /*editProfileButton.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }*/

        // Handle Log Out button click
        logoutButton.setOnClickListener {
            val intent = Intent(this, TripDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }


        // Set up Bottom Navigation
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.nav_profile
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, TripDashboardActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_profile -> {
                    // Already in ProfileActivity
                    true
                }
                else -> false
            }
        }
    }
}
