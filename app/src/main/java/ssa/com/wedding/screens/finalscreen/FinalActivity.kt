package ssa.com.wedding.screens.finalscreen

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ssa.com.wedding.R

class FinalActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, FinalActivity::class.java).apply {
                flags = FLAG_ACTIVITY_CLEAR_TOP
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
    }

    override fun onBackPressed() {
        return
    }
}
