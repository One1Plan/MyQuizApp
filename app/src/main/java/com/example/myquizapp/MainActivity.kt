package com.example.myquizapp

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var score = 0
    private lateinit var questionTextView: TextView
    private lateinit var submitButton: Button
    private lateinit var scoreTextView: TextView
    private lateinit var answersRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        questionTextView = findViewById(R.id.questionTextView)
        submitButton = findViewById(R.id.submitButton)
        scoreTextView = findViewById(R.id.scoreTextView)
        answersRadioGroup = findViewById(R.id.answersRadioGroup)

        // Display the first question
        questionTextView.text = "What is 2 + 2?"

        // Set up submit button click listener
        submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun checkAnswer() {
        // Get selected answer
        val selectedAnswerId = answersRadioGroup.checkedRadioButtonId
        if (selectedAnswerId != -1) {
            val selectedAnswer = findViewById<RadioButton>(selectedAnswerId).text.toString()

            // Check if the answer is correct
            if (selectedAnswer == "4") {
                score++
            }

            // Update score and display new question
            scoreTextView.text = "Score: $score"
            loadNextQuestion()
        }
    }

    private fun loadNextQuestion() {
        // Change question after answering
        questionTextView.text = "What is 3 + 3?"
        val answer1 = findViewById<RadioButton>(R.id.answer1)
        val answer2 = findViewById<RadioButton>(R.id.answer2)
        val answer3 = findViewById<RadioButton>(R.id.answer3)

        // Update answer choices
        answer1.text = "5"
        answer2.text = "6"
        answer3.text = "7"
    }
}
