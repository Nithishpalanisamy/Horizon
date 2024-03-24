package com.example.horizon

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

open class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton =findViewById<Button>(R.id.registerButton)
        val forgetPassword = findViewById<Button>(R.id.forgotPassword)

        loginButton.setOnClickListener {
            if (isValidEmail(email.text.toString()) && isValidPassword(password.text.toString())) {
                val j = Intent(this, Home::class.java)
                startActivity(j)
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
        registerButton.setOnClickListener {
            val k =Intent(this,Register::class.java)
            startActivity(k)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // You can replace this with your own password validation logic
        return password.length >= 6
    }
    open fun back()
    {
        finish()
    }
}

