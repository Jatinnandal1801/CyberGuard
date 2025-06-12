package com.sanjana.cyberguard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var tvPasswordStrength: TextView
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        tvPasswordStrength = findViewById(R.id.tvPasswordStrength)
        btnRegister = findViewById(R.id.btnRegister)

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val strength = getPasswordStrength(s.toString())
                tvPasswordStrength.text = strength
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (username.isEmpty()) {
                etUsername.error = "Username is required"
            } else if (!isValidEmail(email)) {
                etEmail.error = "Invalid email"
            } else if (password.length < 6) {
                etPassword.error = "Password must be at least 6 characters"
            } else if (password != confirmPassword) {
                etConfirmPassword.error = "Passwords do not match"
            } else {
                val userMap = mapOf(
                    "username" to username,
                    "email" to email,
                    "password" to password
                )

                val dbRef = FirebaseDatabase.getInstance().getReference("users")
                dbRef.child(username).setValue(userMap).addOnSuccessListener {
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                    finish() // close and go back to login
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getPasswordStrength(password: String): String {
        val length = password.length
        val hasUpper = password.any { it.isUpperCase() }
        val hasLower = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecial = password.any { "!@#\$%^&*()-_+=<>?/".contains(it) }

        return when {
            length < 6 -> "Weak 🔴"
            length < 8 || !(hasUpper && hasDigit && hasSpecial) -> "Medium 🟠"
            else -> "Strong 🟢"
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
