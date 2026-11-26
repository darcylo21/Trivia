package com.example.trivia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.RadioButton
import com.example.trivia.databinding.ActivitySubjectSelectionBinding
import android.widget.Toast
import android.util.Log

class SubjectSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySubjectSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val radioGroup = binding.radioGroup
        val startButton = binding.startButton

        startButton.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId

            //checks if user has selected an option in the radioGroup

            if (selectedId != -1) {
                val optionSelected = when (selectedId) {
                    binding.rbMovies.id -> binding.rbMovies.text.toString()
                    // ...or keep your findViewById version, it works fine
                    else -> ""
                }
                Log.d("NAV", "starting TriviaZone with $optionSelected")
                startActivity(
                    Intent(this, TriviaZone::class.java).putExtra(
                        "SELECTED_SUBJECT",
                        optionSelected
                    )
                )
            } else {
                Toast.makeText(this, "Pick a subject first", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
