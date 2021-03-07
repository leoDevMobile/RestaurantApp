package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }

    private var clicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_profil.setOnClickListener {
        onAddButtonClicked()

        }

        btn_logout.setOnClickListener {
        Toast.makeText(this, "déconnexion", Toast.LENGTH_SHORT).show()
           // FirebaseAuth.getInstance().signOut()

          //  startActivity(Intent(this, LoginActivity::class.java))
          //  finish()
        }

        btn_tool_float.setOnClickListener {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()

        }




        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)

    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked

    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            btn_logout.visibility = View.VISIBLE
            btn_tool_float.visibility = View.VISIBLE
        }else{
            btn_logout.visibility = View.INVISIBLE
            btn_tool_float.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if(!clicked){
            btn_profil.startAnimation(rotateOpen)
            btn_tool_float.startAnimation(fromBottom)
            btn_logout.startAnimation(fromBottom)
        }else{
            btn_profil.startAnimation(rotateClose)
            btn_tool_float.startAnimation(toBottom)
            btn_logout.startAnimation(toBottom)
        }
    }

    private fun setClickable(clicked: Boolean){

        if(!clicked){
            btn_tool_float.isClickable = true
            btn_logout.isClickable = true
        }else {
            btn_tool_float.isClickable = false
        btn_logout.isClickable = false

    }



}

}


     //   val userId = intent.getStringExtra("user_id")
        //val emailId = intent.getStringExtra("email_id")

        //tv_user_id.text = "user ID :: $userId"
       // tv_email_id.text = "user ID :: $emailId"




