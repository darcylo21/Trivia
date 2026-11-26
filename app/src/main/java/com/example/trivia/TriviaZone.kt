package com.example.trivia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trivia.databinding.ActivityMainBinding
import com.example.trivia.databinding.ActivityTriviaZoneBinding
import android.util.Log

class TriviaZone : AppCompatActivity() {
    private lateinit var binding: ActivityTriviaZoneBinding
    private var subject: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriviaZoneBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        subject = intent.getStringExtra("SELECTED_SUBJECT") ?: ""
        Log.d("NAV", "TriviaZone created, subject=$subject")
    }
}