package com.example.g1owcal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val fname = findViewById<EditText>(R.id.fname)
        val lname = findViewById<EditText>(R.id.lname)
        val email = findViewById<EditText>(R.id.email)
        val phoneNum = findViewById<EditText>(R.id.phoneNum)

        findViewById<Button>(R.id.loginBtn).setOnClickListener {
            val fname = fname.text.toString()
            val lname = lname.text.toString()
            val email = email.text.toString()
            val phoneNum = phoneNum.text.toString()

            val intent = Intent(this, homePage::class.java)
            startActivity(intent)
        }
    }
}