package com.example.aa6notesaap

import android.content.Intent
import android.graphics.Color.alpha
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.alpha
import com.example.aa6notesaap.databinding.ActivityStartPageBinding

class StartPage : AppCompatActivity() {

    private lateinit var binding: ActivityStartPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityStartPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animation.animate().apply {
            duration = 3000
            translationXBy(0f)
            translationYBy(-100f)
            alpha(0.1f)
            setDuration(2000).alpha(1f)
        }.start()

        binding.textView.animate().apply {
            duration = 3000
            translationYBy(100f)
            translationXBy(0f)
            alpha(0.1f)
            setDuration(2000).alpha(1f)
        }.withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}