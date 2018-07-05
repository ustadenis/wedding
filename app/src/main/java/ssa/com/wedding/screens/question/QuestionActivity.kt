package ssa.com.wedding.screens.question

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_question.*
import ssa.com.wedding.R
import ssa.com.wedding.common.App
import ssa.com.wedding.data.Question
import ssa.com.wedding.screens.finalscreen.FinalActivity

class QuestionActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, QuestionActivity::class.java).apply {
                flags = FLAG_ACTIVITY_CLEAR_TOP
            }
        }
    }

    private var currentQuestion: Question? = null

    private var adapter: AnswerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        next.setOnClickListener {
            checkAnswer(adapter?.let { it.answers[it.currentCheck] } ?: answer.text.toString())
        }
        App.nextQuestion()?.let {
            currentQuestion = it
            setUpView(it)
        } ?: startActivity(FinalActivity.createIntent(this))
    }

    override fun onBackPressed() {
        return
    }

    private fun setUpView(question: Question) {
        question.imgRes?.let { questionImg.setImageResource(it) }
        this.question.text = question.question
        if (question.answers?.isEmpty() == false) {
            answers.visibility = View.VISIBLE
            answer.visibility = View.GONE

            adapter = AnswerAdapter(question.answers)
            answers.adapter = adapter
            answers.layoutManager = LinearLayoutManager(this)
        } else {
            answers.visibility = View.GONE
            answer.visibility = View.VISIBLE
        }
        question.imgRes?.let { res ->
            Picasso.get().load(res).placeholder(R.drawable.ic_questions_placeholder).into(questionImg)
            questionImg.setOnClickListener {
                startActivity(PhotoActivity.createIntent(this, res))
            }
        }
    }

    private fun checkAnswer(answer: String?) {
        if (currentQuestion?.answer?.equals(answer, true) == true) {
            currentQuestion?.rightImgRes?.let { res ->
                Picasso.get().load(res).placeholder(R.drawable.ic_questions_placeholder).into(questionImg)
                questionImg.setOnClickListener {
                    startActivity(PhotoActivity.createIntent(this, res))
                }
            }
            adapter?.enabled = false
            this.answer.isEnabled = false
            next.setOnClickListener { startActivity(createIntent(this)) }
            next.text = "Следующий вопрос"
            showValidAnswer()
        } else {
            showInvalidAnswer()
        }
    }

    private fun showInvalidAnswer() {
        Snackbar.make(answers, "Ответ неверный, попробуйте еще)", Snackbar.LENGTH_SHORT).show()
    }

    private fun showValidAnswer() {
        Snackbar.make(answers, "Правильно!)", Snackbar.LENGTH_SHORT).show()
    }
}
