package com.example.horizon

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

open class Launch: MainActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launchpage)
        val seeker = findViewById<Button>(R.id.butt1)
        val employee = findViewById<Button>(R.id.butt2)
        seeker.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
        employee.setOnClickListener {
            startActivity(Intent(this,Hirehome::class.java))
        }
    }
}