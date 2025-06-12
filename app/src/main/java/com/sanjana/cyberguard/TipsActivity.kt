package com.sanjana.cyberguard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.sanjana.cyberguard.databinding.ActivityTipsBinding

class TipsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Display security tips using string resource with HTML formatting
        val tipsHtml = getString(R.string.tips_content)
        binding.tipsTextView.text = HtmlCompat.fromHtml(tipsHtml, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
