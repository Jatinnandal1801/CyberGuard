package com.sanjana.cyberguard

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val eyeIcon = findViewById<ImageView>(R.id.eyeIcon)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerLink = findViewById<TextView>(R.id.registerLink)

        eyeIcon.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordInput.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_eye_off)
            } else {
                passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeIcon.setImageResource(R.drawable.ic_eye)
            }
            passwordInput.setSelection(passwordInput.text.length)
        }

        loginButton.setOnClickListener {
            // Get the username and password input
            val username = findViewById<EditText>(R.id.emailInput).text.toString()
            val password = findViewById<EditText>(R.id.passwordInput).text.toString()

            // Predefined username and password (you can replace these with values from a database or API in real apps)
            val validUsername = "admin"
            val validPassword = "password"

            // Validate the credentials
            if (username == validUsername && password == validPassword) {
                // If credentials are correct, navigate to AboutAppActivity
                val intent = Intent(this, AboutAppActivity::class.java)
                startActivity(intent)
            } else {
                // If credentials are invalid, show an error message
                Toast.makeText(this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }


        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
