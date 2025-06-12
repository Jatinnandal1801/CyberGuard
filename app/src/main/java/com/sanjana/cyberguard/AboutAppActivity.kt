package com.sanjana.cyberguard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutapp)

        val btnChatbot = findViewById<Button>(R.id.btnChatbot)
        val btnExploreModules = findViewById<Button>(R.id.btnExploreModules)
        val btnMeetDevelopers = findViewById<Button>(R.id.btnMeetDevelopers)
        btnMeetDevelopers.setOnClickListener {
            val intent = Intent(this, DevelopersActivity::class.java)
            startActivity(intent)
        }


        btnChatbot.setOnClickListener {
            val intent = Intent(this, ChatbotActivity::class.java)
            startActivity(intent)
        }

        btnExploreModules.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // or your module activity
            startActivity(intent)
        }
    }
}
