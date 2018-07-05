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
                    question = "Какой город изображен на фоне этой фотографии?",
                    forWhom = "Публика",
                    answers = listOf("Москва", "Питер", "Ташкент"),
                    answer = "Питер",
                    imgRes = R.drawable.first,
                    rightImgRes = R.drawable.first_right
            ))
            questions.add(Question(
                    question = "Когда было сделано предложение Ксюше? Напишите число и месяц через пробел!",
                    forWhom = "Ксюша",
                    answers = null,
                    answer = "14 Февраля"
            ))
            questions.add(Question(
                    question = "Кто третий член новой семьи?",
                    forWhom = "Публика",
                    answers = null,
                    answer = "Кора",
                    rightImgRes = R.drawable.kora
            ))
            questions.add(Question(
                    question = "Что на изображено на фоне этой фотографии?",
                    forWhom = "Публика",
                    answers = listOf("Университет", "Дом", "Елка"),
                    answer = "Елка",
                    imgRes = R.drawable.tree,
                    rightImgRes = R.drawable.tree_right
            ))
            questions.add(Question(
                    question = "Этого человека всегда все палит)",
                    forWhom = "Артем",
                    answers = null,
                    answer = "Боб",
                    imgRes = R.drawable.bob,
                    rightImgRes = R.drawable.bob_right
            ))
            questions.add(Question(
                    question = "Как называется деревня, в которую мы часто ездим отдыхать?",
                    forWhom = "Артем и Ксюша",
                    answers = listOf("Мяктево", "Мякотинское", "Мякишки", "Мятово"),
                    answer = "Мякотинское",
                    imgRes = R.drawable.mik
            ))
            questions.add(Question(
                    question = "Где Артем и Ксюша встретились впервые?",
                    forWhom = "Публика",
                    answers = null,
                    answer = "Университет",
                    imgRes = R.drawable.meet
            ))
            questions.add(Question(
                    question = "Ребята! Какой ваш самый счастливый день!?",
                    forWhom = "Артем и Ксюша",
                    answers = listOf("День рождения", "8 марта", "23 февраля", "Сегодня!!!!"),
                    answer = "Сегодня!!!!",
                    imgRes = R.drawable.heart
            ))
        }

        fun nextQuestion(): Question? {
            return if (!questions.isEmpty()) questions.removeAt(0) else null
        }
    }
}