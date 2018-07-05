package ssa.com.wedding.screens.splash

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import ssa.com.wedding.R
import ssa.com.wedding.common.App
import ssa.com.wedding.screens.question.QuestionActivity

class MainActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startTest.setOnClickListener {
            App.createQuestions()
            startActivity(QuestionActivity.createIntent(this))
        }
    }
}
