package com.example.g1owcal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*

class productListsDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val viewName = findViewById<TextView>(R.id.productName)
        val viewImage = findViewById<ImageView>(R.id.productImage)

        var products: Array<String> = arrayOf()
        val position = intent.extras!!.getString("product")

        when {
            position.equals("Ube Jam 12 oz") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.ube_jam)
                products = arrayOf("")
            }
            position.equals("Peanut Brittle 370g") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.peanut_brittle)
                products = arrayOf("")
            }
            position.equals("Strawberry Jam 80z") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.strawberry_jam)
                products = arrayOf("")
            }
            position.equals("Snow Balls 320g") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.snow_balls)
                products = arrayOf("")
            }
            position.equals("Cashew Brittle 330g") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.cashew_brittle)
                products = arrayOf("")
            }
            position.equals("Cashew Crunch 250g") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.cashew_crunch)
                products = arrayOf("")
            }
            position.equals("Strawberry Jam 12oz") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.strawberry_jam_big)
                products = arrayOf("")
            }
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, products)
        val productsListView = findViewById<ListView>(R.id.prodListView)
        productsListView.adapter = adapter
        registerForContextMenu(productsListView)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_to_cart, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_to_cart -> {
                Toast.makeText(this, "Added to Cart", Toast.LENGTH_LONG).show()
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                cartItems.add(productsArray[info.position])
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.go_to_cart -> {
                val intent = Intent(this, cartActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.go_to_user_account -> {
                true
            }
            R.id.go_to_settings -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    var cartItems = arrayListOf<String>()
    val productsArray = arrayOf("")
}