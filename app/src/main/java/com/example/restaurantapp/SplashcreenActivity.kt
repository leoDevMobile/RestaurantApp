package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splashcreen.*

class SplashcreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashcreen)

        iv_calendar.alpha = 0f
        iv_calendar.animate().setDuration(5000).alpha(1f).withEndAction {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}