package ssa.com.wedding.data

data class Question(
        val question: String,
        val forWhom: String,
        val answers: List<String>?,
        val answer: String,
        val imgRes: Int? = null)