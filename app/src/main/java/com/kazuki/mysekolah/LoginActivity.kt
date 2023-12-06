package com.kazuki.mysekolah

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    /**
     * declarations of btn and component on loginPage
     */
    lateinit var btnLogin: Button
    lateinit var userEmail: TextInputLayout
    lateinit var inputEmail: TextInputEditText
    lateinit var userPassword: TextInputLayout
    lateinit var inputPassword: TextInputEditText
    lateinit var containerView: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        containerView = findViewById(R.id.container)
        btnLogin = findViewById(R.id.buttonLogin)
        userEmail = findViewById(R.id.placehoderEmail)
        inputEmail = findViewById(R.id.userEmailInput)
        userPassword = findViewById(R.id.placehoderPassword)
        inputPassword = findViewById(R.id.userPasswordInput)

        btnLogin.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            validation(email, password)
            /*Snackbar.make(it, "Login", Snackbar.LENGTH_SHORT).show()*/
        }

        inputEmail.doOnTextChanged { text, start, before, count ->
            userEmail.error = null
            userEmail.isErrorEnabled = false
        }

        inputPassword.doOnTextChanged { text, start, before, count ->
            userPassword.error = null
            userPassword.isErrorEnabled = false
        }
    }
    private  fun validation(email: String, password: String) {
        val defaultEmail = "kazuki@gmail.com"
        val defaultPassword = "12345"
        if(email != defaultEmail) {
            userEmail.error = "Email belum terdaftar"
            /*Snackbar.make(containerView.rootView, "Email belum terdaftar", Snackbar.LENGTH_SHORT).show()*/
        } else if(password != defaultPassword) {
            userEmail.error = "email/password salah"
            userPassword.error = "email/password salah"
            /*Snackbar.make(containerView.rootView, "Email/Password Salah", Snackbar.LENGTH_SHORT).show()*/
        } else {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtras(
                bundleOf(
                    "LoginSuccess" to "Berhasil Login",
                    "userEmail" to email
                )
            )
            startActivity(intent)
        }
    }
}