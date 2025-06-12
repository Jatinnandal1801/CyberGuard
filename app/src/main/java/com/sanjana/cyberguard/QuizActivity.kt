package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sanjana.cyberguard.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private val questions = listOf(
        "What is phishing?" to listOf("A fish species", "Cyber attack", "Programming language", "Security software"),
        "What does 2FA stand for?" to listOf("Two-Factor Authentication", "Two-Factor Attack", "File Access", "Data Encryption"),
        "What is malware?" to listOf("Malicious software", "Antivirus software", "A coding language", "A system tool"),
        "What does VPN stand for?" to listOf("Virtual Private Network", "Virtual Public Network", "Vulnerable Protection Network", "Voice Protocol Network"),
        "What is the purpose of a firewall?" to listOf("Control network traffic", "Encrypt data", "Backup data", "Speed up internet connection"),
        "What is a DDoS attack?" to listOf("Direct Denial of Service", "Distributed Denial of Service", "Dynamic Data Service", "Domain Data Security"),
        "What does HTTPS stand for?" to listOf("Hyper Text Transfer Protocol Secure", "Hyper Transfer Text Secure", "Hyperlink Text Protocol Secure", "Hyper Text Tracking Protocol Secure"),
        "What is social engineering?" to listOf("A hacking technique", "The manipulation of people", "A security software", "A network protocol"),
        "What is ransomware?" to listOf("Software that encrypts data for ransom", "A type of virus", "A network attack", "A secure password manager"),
        "What is an IP address?" to listOf("Internet Protocol address", "Intelligent Processing address", "Interconnected Protocol address", "Internal Protection address")
    )
    private val answers = listOf(1, 0, 0, 0, 0, 1, 0, 1, 0, 0)
    private var currentQuestion = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadQuestion()

        binding.submitButton.setOnClickListener {
            val selectedOption = binding.optionsGroup.checkedRadioButtonId
            if (selectedOption == -1) {
                Toast.makeText(this, "Select an answer!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val answerIndex = binding.optionsGroup.indexOfChild(findViewById(selectedOption))
            if (answerIndex == answers[currentQuestion]) score++

            if (currentQuestion < questions.size - 1) {
                currentQuestion++
                loadQuestion()
            } else {
                Toast.makeText(this, "Quiz Over! Score: $score/${questions.size}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loadQuestion() {
        binding.questionText.text = questions[currentQuestion].first
        val options = questions[currentQuestion].second
        binding.option1.text = options[0]
        binding.option2.text = options[1]
        binding.option3.text = options[2]
        binding.option4.text = options[3]
        binding.optionsGroup.clearCheck()
    }
}
