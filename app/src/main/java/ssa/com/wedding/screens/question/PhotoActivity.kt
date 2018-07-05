package ssa.com.wedding.screens.question

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ssa.com.wedding.R
import android.support.v4.app.ActivityCompat
import android.os.Build
import android.transition.Fade
import kotlinx.android.synthetic.main.activity_photo.*


class PhotoActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_RES = "extra_res"
        fun createIntent(context: Context, res: Int): Intent {
            return Intent(context, PhotoActivity::class.java).apply { putExtra(EXTRA_RES, res) }
        }
    }

    private val recourse: Int by lazy { intent.getIntExtra(EXTRA_RES, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        snappyImageViewer.setImageResource(recourse)
        snappyImageViewer.addOnClosedListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.sharedElementReturnTransition = Fade(Fade.IN)
            }
            ActivityCompat.finishAfterTransition(this@PhotoActivity)
        }
    }
}
