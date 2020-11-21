package com.example.g1owcal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class cartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productsArray)
        val cartListView = findViewById<ListView>(R.id.cartProductsList)
        cartListView.adapter = adapter

    }
}