package com.example.travelcompanion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchEditText = findViewById<EditText>(R.id.search_edit_text)
        val noResultsTextView = findViewById<TextView>(R.id.tv_no_results)
        val recyclerView = findViewById<RecyclerView>(R.id.results_recycler_view)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Mock data
        val mockResults = listOf("Hotel in Paris", "Luxury Resort", "City Tour", "Beach Resort","Paris Museums", "Abu Dhabi", "Barcelona")

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = SearchResultsAdapter(mockResults) { selectedItem ->
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://example.com/$selectedItem")
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        // Handle search input
        searchEditText.addTextChangedListener {
            val filteredResults = mockResults.filter { it.contains(searchEditText.text, ignoreCase = true) }
            noResultsTextView.visibility = if (filteredResults.isEmpty()) View.VISIBLE else View.GONE
            recyclerView.adapter = SearchResultsAdapter(filteredResults) { selectedItem ->
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://example.com/$selectedItem")
                }
                startActivity(intent)
            }
        }

        // Bottom Navigation
        bottomNavigation.selectedItemId = R.id.nav_search
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, TripDashboardActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_search -> true
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
