package com.example.horizon

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Register:MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        val registerButton =findViewById<Button>(R.id.registerButton)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val password = findViewById<EditText>(R.id.password)
        val email = findViewById<EditText>(R.id.email)
      //  val name = findViewById<EditText>(R.id.name)
        val confirmpassword = findViewById<EditText>(R.id.confirm_password)
        registerButton.setOnClickListener {

            if (isValidEmail(email.text.toString()) && isValidPassword(password.text.toString()) && password.text.toString() == confirmpassword.text.toString()) {
                val j = Intent(this, Home::class.java)
                startActivity(j)
            } else {
                Toast.makeText(this, "Invalid Credential", Toast.LENGTH_SHORT).show()
            }
        }
        loginButton.setOnClickListener {
            val i =Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // You can replace this with your own password validation logic
        return password.length >= 8
    }
    override fun back(){
        val i=Intent(this,MainActivity::class.java)
        startActivity(i)
    }
}
