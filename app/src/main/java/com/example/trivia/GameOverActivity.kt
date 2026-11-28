package com.example.trivia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trivia.databinding.ActivityGameOverBinding
import android.content.Intent



class GameOverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameOverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("Score", 0)
        val correct = intent.getIntExtra("Correct", 0)
        val total = intent.getIntExtra("Total", 0)

        binding.tvTotalScore.text = "Score: $score"
        binding.tvCorrectQues.text = "$correct out of $total correct"

        binding.btnPlayAgain.setOnClickListener {
            val i = Intent(this, SubjectSelectionActivity::class.java)
            startActivity(i)
        }
    }

}