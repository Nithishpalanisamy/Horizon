package com.example.horizon

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Register : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        val auth = FirebaseAuth.getInstance()
        val registerButton = findViewById<Button>(R.id.registerButton)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val password = findViewById<EditText>(R.id.password)
        val email = findViewById<EditText>(R.id.email)
        val confirmpassword = findViewById<EditText>(R.id.confirm_password)

        registerButton.setOnClickListener {
            val user = email.text.toString().trim()
            val pass = password.text.toString().trim()
            val confirmPass = confirmpassword.text.toString().trim()

            if (user.isEmpty()) {
                email.error = "Email cannot be empty"
            } else if (!isValidEmail(user)) {
                email.error = "Please enter a valid email"
            } else if (pass.isEmpty()) {
                password.error = "Password cannot be empty"
            } else if (!isValidPassword(pass)) {
                password.error = "Invalid password"
            } else if (pass != confirmPass) {
                confirmpassword.error = "Passwords do not match"
            } else {
                auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(this, "Signup Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        loginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
