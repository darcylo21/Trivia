
package com.example.trivia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class TriviaViewModel : ViewModel() {

    private var questions: List<Question> = emptyList()
    private var currentQuestionIndex = 0


    //Use variables that hold live data
    val currentQuestion = MutableLiveData<Question?>()
    val quizComplete = MutableLiveData<Boolean>()
    val score = MutableLiveData<Int>()

    val correctNum = MutableLiveData<Int>()

    init {
        score.value = 0
        correctNum.value = 0
        quizComplete.value = false
    }

    //This is the map that contains the questions
    //The key is the subject matter
    //The value is a list of questions objects that hold all the question data (question,options,asnwer)
    private val triviaQuestions = mapOf(
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
                listOf("Ag", "Fe", "Au", "Go"),
                "Au"
            )
        ),
        "Movies" to listOf(
            Question(
                "Who is the actor for IronMan in the MCU?",
                listOf("Robert Downey Jr", "Chris Hemsworth", "Leonardo Decaprio", "Tobey Maguire"),
                "Robert Downey Jr"
            ),
            Question(
                "What is the name of the fictional African nation in Black Panther?",
                listOf("Genovia", "Zamunda", "Wakanda", "Sokovia"),
                "Wakanda"
            ),
            Question(
                "Who plays the human lifeguard in the first SpongeBob Movie?",
                listOf("David Schwimmer", "David Duchovny", "David Hasselhoff", "David Darwin"),
                "David Hasselhoff"
            )
        ),
        "Video Games" to listOf(
            Question(
                "What year did the first Halo game release?",
                listOf("1999", "2000", "2001", "2003"),
                "2001"
            ),
            Question(
                "Which company developed Minecraft?",
                listOf("Valve", "Epic Games", "Mojang", "Nintendo"),
                "Mojang"
            ),
            Question(
                "What year was the original PlayStation released?",
                listOf("1990", "1994", "1998", "2000"),
                "1994"
            )
        )
    )


    //Initialized all relevant variables such as score, questions, and the completeness flag
    //Calls a function to populate the question data to the ui elements
    fun startQuiz(subject: String) {
        questions = triviaQuestions[subject] ?: emptyList()
        currentQuestionIndex = 0
        score.value = 0
        correctNum.value = 0
        quizComplete.value = false
        showCurrentQuestion()
    }


    //This function goes through the map of questions and assigns the currentQuestion variable
    //Which is a questions object the question at that particular index in the list
    private fun showCurrentQuestion() {
        if (currentQuestionIndex < questions.size) {
            currentQuestion.value = questions[currentQuestionIndex]
        } else {
            currentQuestion.value = null
            quizComplete.value = true
        }
    }


    // Add to the score if answer is correct
    // And increment the currentQuestionIndex to move to next question
    fun submitAnswer(answer: String) {
        val question = currentQuestion.value ?: return

        if (answer == question.answer) {
            score.value = (score.value ?: 0) + 10
            correctNum.value = (correctNum.value?:0)+1
        }

        currentQuestionIndex++
        showCurrentQuestion()
    }
}
