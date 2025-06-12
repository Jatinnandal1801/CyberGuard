package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DevelopersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developers)

        val developersDescription = """
            Our CyberGuard team is a passionate and dedicated group of students who came together with a shared goal — to make cybersecurity awareness accessible and easy for everyone.
            
            We’ve worked collaboratively to design, develop, and refine this app with care and creativity, ensuring both user-friendly design and reliable features.
            
            Meet the Team:
            👨‍💻 Jatin Nandal – Front End Developer & Animations
            🎨 Sanjana Srivastava – Front End Developer & Designer  
            🖥️ Khushi Nain – Backend Developer  
            💡 Rashi Jain – Backend Developer & Designer 

            We hope you enjoy using CyberGuard as much as we enjoyed building it!
        """.trimIndent()

        val textView = findViewById<TextView>(R.id.tvDevelopers)
        textView.text = developersDescription
    }
}
