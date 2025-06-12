package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ChatbotActivity : AppCompatActivity() {

    private lateinit var chatContainer: LinearLayout
    private lateinit var etUserInput: EditText
    private lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        chatContainer = findViewById(R.id.chatContainer)
        etUserInput = findViewById(R.id.etUserInput)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener {
            val userMessage = etUserInput.text.toString()
            if (userMessage.isNotBlank()) {
                addMessage(userMessage, true)
                val botResponse = getBotResponse(userMessage)
                addMessage(botResponse, false)
                etUserInput.text.clear()
            }
        }
    }

    private fun addMessage(message: String, isUser: Boolean) {
        val textView = TextView(this)
        textView.text = message
        textView.textSize = 16f
        textView.setPadding(10, 10, 10, 10)

        if (isUser) {
            textView.setBackgroundResource(android.R.color.holo_blue_light)
        } else {
            textView.setBackgroundResource(android.R.color.holo_green_light)
        }

        chatContainer.addView(textView)
    }

    private fun getBotResponse(userInput: String): String {
        val responses = mapOf(
            "phishing" to """
            🔐 **Phishing** is a social engineering attack used to steal user data, including login credentials and credit card numbers.

            🧠 **How it works**: Attackers disguise themselves as trusted entities via email, SMS, or websites to trick users into providing sensitive info.

            🧩 **Types of Phishing**:
            • Email Phishing – Fake emails urging urgent action.
            • Spear Phishing – Targeted attacks on specific individuals.
            • Whaling – Targeting executives or high-profile users.
            • Vishing – Voice phishing over calls.
            • Smishing – SMS-based phishing.

            🛡️ **Countermeasures**:
            • Never click on suspicious links.
            • Check sender’s email address carefully.
            • Use spam filters and report phishing attempts.
            • Enable multi-factor authentication (MFA).
            • Keep security software up to date.

            💡 Tip: Always verify the URL before entering credentials.

        """.trimIndent(),

            "malware" to """
            ☠️ **Malware** (malicious software) is designed to damage, disrupt, or gain unauthorized access to systems.

            📦 **Types**:
            • Virus
            • Worms
            • Trojans
            • Ransomware
            • Spyware
            • Adware

            🛡️ **Protection**:
            • Keep antivirus software updated.
            • Avoid downloading attachments from unknown sources.
            • Update OS and applications regularly.
        """.trimIndent(),

            "ransomware" to """
            🔒 **Ransomware** locks or encrypts your data, demanding payment for release.

            🧨 **How it Spreads**:
            • Phishing emails
            • Malicious downloads
            • Unpatched software vulnerabilities

            💥 **Prevention**:
            • Backup data frequently
            • Avoid suspicious links/attachments
            • Install OS and security updates
        """.trimIndent(),

            "2fa" to """
            🛡️ **Two-Factor Authentication (2FA)** adds a second step in login—usually a one-time code via SMS, app, or hardware key.

            ✅ **Benefits**:
            • Prevents unauthorized access
            • Useful even if password is compromised

            💡 Use apps like Google Authenticator, Authy, or hardware keys like YubiKey.
        """.trimIndent(),

            "password" to """
            🔐 **Password Security** is critical for protecting your accounts.

            📏 **Best Practices**:
            • Use at least 12 characters with symbols, numbers, and mixed case
            • Never reuse passwords
            • Store in a password manager
            • Avoid dictionary words

            💡 Consider passphrases: "T1m3Tosecure!"
        """.trimIndent(),

            "public wifi" to """
            📡 **Public Wi-Fi Risks**: Hackers can intercept traffic on open networks.

            🔓 **Risks**:
            • Man-in-the-middle attacks
            • Data sniffing
            • Malware injection

            🔐 **Safety Tips**:
            • Use a VPN
            • Disable auto-connect
            • Avoid accessing sensitive accounts
        """.trimIndent(),

            "firewall" to """
            🔥 **Firewalls** monitor and filter incoming/outgoing network traffic.

            🧱 **Types**:
            • Hardware firewalls
            • Software firewalls

            🛡️ **Use it to**:
            • Block unauthorized access
            • Control outbound connections
        """.trimIndent(),

            "antivirus" to """
            🛡️ **Antivirus software** detects and removes malicious programs.

            🧪 **Common Features**:
            • Real-time scanning
            • Automatic updates
            • Quarantine and removal

            💡 Keep it updated and schedule regular scans.
        """.trimIndent(),

            "spam" to """
            📬 **Spam** refers to unwanted, unsolicited messages—often phishing or scams.

            🛑 **Dangers**:
            • Links to malware
            • Phishing traps

            ✅ **Protection**:
            • Use spam filters
            • Don't click unknown links
        """.trimIndent(),

            "encryption" to """
            🔐 **Encryption** converts data into unreadable format without a key.

            🧰 **Types**:
            • Symmetric (AES)
            • Asymmetric (RSA)

            📲 **Use Cases**:
            • Secure messaging
            • File storage
            • HTTPS for websites

            💡 Always use apps and services with end-to-end encryption.
        """.trimIndent(),

            "updates" to """
            🔄 **Software Updates** fix vulnerabilities in OS and apps.

            🛡️ **Why It Matters**:
            • Prevents exploitation of known bugs
            • Improves system stability

            🔔 **Tip**: Enable auto-updates for critical software.
        """.trimIndent(),

            "safe browsing" to """
            🌐 **Safe Browsing** habits protect you from scams and malware.

            🛡️ **Tips**:
            • Only visit HTTPS websites
            • Avoid suspicious pop-ups
            • Don't auto-save passwords on shared devices
        """.trimIndent()
        )

        return responses.entries.find { userInput.contains(it.key, ignoreCase = true) }?.value
            ?: "🤖 I'm still learning! Try asking about phishing, malware, 2FA, encryption, or firewalls."
    }

}
