package com.sanjana.cyberguard

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var logo: ImageView
    private lateinit var welcomeLayout: RelativeLayout
    private lateinit var appName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        logo = findViewById(R.id.logo)
        welcomeLayout = findViewById(R.id.welcomeLayout)
        appName = findViewById(R.id.appName)

        // Start background color animation from White to Black
        val colorFrom = Color.parseColor("#FFFFFF")
        val colorTo = Color.parseColor("#000000")
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.duration = 3000 // 3 seconds
        colorAnimation.addUpdateListener { animator ->
            welcomeLayout.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()

        // Start Typewriter Effect for App Name
        typeWriterEffect(appName, "CyberGuard")

        // Move to Login after 3.5 seconds
        logo.postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3500)
    }

    private fun typeWriterEffect(textView: TextView, text: String, delay: Long = 200) {
        textView.text = ""
        var index = 0
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                if (index <= text.length) {
                    textView.text = text.substring(0, index)
                    index++
                    handler.postDelayed(this, delay)
                }
            }
        }
        handler.post(runnable)
    }
}
