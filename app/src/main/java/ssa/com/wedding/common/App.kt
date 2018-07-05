package ssa.com.wedding.common

import android.app.Application
import ssa.com.wedding.R
import ssa.com.wedding.data.Question

class App: Application() {

    companion object {
        private var questions: MutableList<Question> = mutableListOf()

        fun createQuestions() {
            questions = mutableListOf()
            questions.add(Question(
                    question = "Test",
                    forWhom = "Artem",
                    answers = listOf("test", "bob", "hui"),
                    answer = "bob",
                    imgRes = R.drawable.testimg
            ))
            questions.add(Question(
                    question = "Test1",
                    forWhom = "Artem",
                    answers = null,
                    answer = "bob"
            ))
            questions.add(Question(
                    question = "Test2",
                    forWhom = "Artem",
                    answers = listOf("test", "bob", "hui"),
                    answer = "bob",
                    imgRes = R.drawable.testimg
            ))
        }

        fun nextQuestion(): Question? {
            return if (!questions.isEmpty()) questions.removeAt(0) else null
        }
    }
}