package com.sanjana.cyberguard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.sanjana.cyberguard.databinding.ActivityThreatsBinding

class ThreatsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val html = getString(R.string.threats_content)
        binding.threatsTextView.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
