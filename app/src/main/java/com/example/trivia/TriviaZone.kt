package com.example.trivia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trivia.databinding.ActivityMainBinding
import com.example.trivia.databinding.ActivityTriviaZoneBinding
import android.util.Log


data class Question(
    val question: String,
    val options: List<String>,
    val answer: String
)
class TriviaZone : AppCompatActivity() {
    private lateinit var binding: ActivityTriviaZoneBinding
    private var subject: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriviaZoneBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        subject = intent.getStringExtra("SELECTED_SUBJECT") ?: ""

        val triviaQuestions = mapOf(
            "Science" to listOf(
                Question(
                    "What planet is closest to the Sun?",
                    listOf("Earth", "Mercury", "Mars", "Venus"),
                    "Mercury"
                ),
                Question(
                    "What gas do plants absorb?",
                    listOf("Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"),
                    "Carbon Dioxide"
                ),
                Question(
                    "What is the chemical symbol for gold?",
                    listOf("Ag","Fe","Au","Go"),
                    "Au"
                )
            ),

            "Movies" to listOf(
                Question(
                    "Who is the actor for IronMan in the MCU?",
                    listOf("Robert Downey Jr", "Chris Hemsworth", "Leonardo Decaprio", "Tobey Maguire"),
                    "Robert Downey Jr"
                ),
                Question("What is the name of the fictional African nation in Black Panther?",
                listOf("Genovia","Zamunda","Wakanda","Sokovia"),
                "Wakanda"
                ),
                Question("Who plays the human lifeguard in the first SpongeBob Movie?",
                    listOf("David Schwimmer","David Duchovny","David Hasselhoff","David Darwin"),
                    "David Hasselhoff"
                )
            ),
            "Video Games" to listOf(
                Question(
                    "What year did the first Halo game release?",
                    listOf("1999", "2000","2001", "2003"),
                    "2001"
                ),
                Question("Which company developed Minecraft?",
                    listOf("Valve","Epic Games","Mojang","Nintendo"),
                    "Mojang"
                ),
                Question("What year was the original PlayStation released?",
                    listOf("1990","1994","1998","2000"),
                    "1994"
                )

            )
        )
    }
}