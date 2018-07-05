package ssa.com.wedding.screens.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*
import ssa.com.wedding.R
import ssa.com.wedding.common.App
import ssa.com.wedding.screens.question.QuestionActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            startActivity(MainActivity.createIntent(this))
        }, 2000)
    }
}
