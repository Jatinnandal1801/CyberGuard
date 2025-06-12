package com.sanjana.cyberguard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.sanjana.cyberguard.databinding.ActivityModulesBinding

class ModulesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModulesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModulesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Display OWASP Top Ten content with formatting
        val owaspContent = getString(R.string.module_content)
        binding.moduleTextView.text = HtmlCompat.fromHtml(owaspContent, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
