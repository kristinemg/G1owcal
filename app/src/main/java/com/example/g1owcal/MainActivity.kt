package com.example.g1owcal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val signUp = findViewById<TextView>(R.id.signUp)

        findViewById<Button>(R.id.loginBtn).setOnClickListener{
            val email = email.text.toString()
            val password = password.text.toString()

            val intent = Intent(this, homePage::class.java)
            //intent.putExtra("fname", fname)
            startActivity(intent)
        }

        signUp.setOnClickListener{

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            signUp.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}