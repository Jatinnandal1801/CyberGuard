package com.sanjana.cyberguard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanjana.cyberguard.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle button clicks for different modules
        binding.modulesButton.setOnClickListener {
            startActivity(Intent(this, ModulesActivity::class.java))
        }

        binding.tipsButton.setOnClickListener {
            startActivity(Intent(this, TipsActivity::class.java))
        }

        binding.threatsButton.setOnClickListener {
            startActivity(Intent(this, ThreatsActivity::class.java))
        }



        binding.quizButton.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }

        binding.newsFeedButton.setOnClickListener {
            startActivity(Intent(this, NewsFeedActivity::class.java))
        }



        binding.securityCheckupButton.setOnClickListener {
            startActivity(Intent(this, SecurityCheckupActivity::class.java))
        }

        binding.habitTrackerButton.setOnClickListener {
            startActivity(Intent(this, HabitTrackerActivity::class.java))
        }

        binding.terminalButton.setOnClickListener {
            startActivity(Intent(this, TerminalActivity::class.java))
        }

    }
}
