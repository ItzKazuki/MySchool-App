package com.kazuki.mysekolah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var extra = intent.extras
        val message = extra?.getString("LoginSuccess")
        val email = extra?.getString("userEmail")

        val container = findViewById<ConstraintLayout>(R.id.container)
        Snackbar.make(container.rootView, message + " " + email, Snackbar.LENGTH_SHORT).show()
    }
}