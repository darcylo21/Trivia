package com.example.trivia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trivia.databinding.ActivityTriviaZoneBinding
import android.util.Log
import android.widget.RadioButton
import androidx.lifecycle.ViewModelProvider

//Created a data class called questions
//Used to create a custom object that holds our question data
//It includes the question itself
//The options as a list
//The answer as a string
data class Question(
    val question: String,
    val options: List<String>,
    val answer: String
)

class TriviaZone : AppCompatActivity() {
    private lateinit var viewModel: TriviaViewModel
    private lateinit var binding: ActivityTriviaZoneBinding
    private var subject: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Connect the viewModel to use its functions and data
        viewModel = ViewModelProvider(this)[TriviaViewModel::class.java]
        binding = ActivityTriviaZoneBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        //Retrieve the subject chosen from the last activity
        subject = intent.getStringExtra("SELECTED_SUBJECT") ?: ""

        //Begin quiz
        viewModel.startQuiz(subject)

        //Retrieve data from the view model and populate the ui elements with that data
        //It passes the currentQuestion parameter from the viewModel and uses live data with the observe method
        viewModel.currentQuestion.observe(this) { question ->

            if (question != null) {
                binding.tvQuestionText.text = question.question

                binding.rbOptionOne.text = question.options[0]
                binding.rbOptionTwo.text = question.options[1]
                binding.rbOptionThree.text = question.options[2]
                binding.rbOptionFour.text = question.options[3]

                //Continue loop until all questions are answered
                binding.rgQuestionOptions.clearCheck()
            } else {
                binding.tvQuestionText.text = "Quiz Complete!"
            }
        }

            //Listner for the radiogroup this triggers the next question to pop up
            binding.rgQuestionOptions.setOnCheckedChangeListener { group, checkedId ->

                if (checkedId != -1) {
                    val selectedAnswer =
                        group.findViewById<RadioButton>(checkedId).text.toString()

                    viewModel.submitAnswer(selectedAnswer)
                }
            }

            //Calls function from viewModel to get the score of the user after the game is over.
            viewModel.score.observe(this) { currentScore ->
                Log.d("Trivia", "Score: $currentScore")
            }



    }
}