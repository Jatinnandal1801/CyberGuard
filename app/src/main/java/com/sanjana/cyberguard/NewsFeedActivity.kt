package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NewsFeedActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val newsList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        listView = findViewById(R.id.newsListView)

        // Manually adding top 10 cybersecurity news
        addTopCybersecurityNews()

        // Setting up the adapter to display news
        val adapter = ArrayAdapter(this@NewsFeedActivity, android.R.layout.simple_list_item_1, newsList)
        listView.adapter = adapter
    }

    private fun addTopCybersecurityNews() {
        // Adding top 10 cybersecurity news articles
        newsList.add("1. Pakistan Launches Cyberattacks Amid pahalgam incident Tensions")
        newsList.add("2. Texas Health Department Data Breach Exposes 61,000 Individuals' Information")
        newsList.add("3. Scattered Spider Group Targets UK Retailer Marks & Spencer")
        newsList.add("4. Global Cybersecurity Outlook 2025: Rising Threats")
        newsList.add("5. Leaders of Online Exploitation Group 764 Charged")
        newsList.add("6. AI-Powered Phishing Campaigns on the Rise")
        newsList.add("7. Microsoft and Apple Release Emergency Security Patches")
        newsList.add("8. Ransomware Attacks Continue to Impact Critical Sectors")
        newsList.add("9. Cybersecurity Firms Raise Over $1.7 Billion Ahead of RSA Conference")
        newsList.add("10. Emerging Threats from AI-Driven Cyberattacks")
    }
}