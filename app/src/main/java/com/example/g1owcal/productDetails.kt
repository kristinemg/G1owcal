package com.example.g1owcal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*

class productDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val viewName = findViewById<TextView>(R.id.categoryName)
        val viewImage = findViewById<ImageView>(R.id.categoryImage)

        var products: Array<String> = arrayOf()
        val position = intent.extras!!.getString("position")

        when {
            position.equals("BAGS") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.ic_launcher_background)
                products = arrayOf("")
            }
            position.equals("TREATS") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.ic_launcher_background)
                products = arrayOf(
                        "Ube Jam 12 oz - PhP 230.00", "Peanut Brittle 370g - PhP 185.00",
                        "Strawberry Jam 80z - PhP 225.00", "Snow Balls 320g - PhP 320.00",
                        "Cashew Brittle 330g - PhP 295.00", "Cashew Crunch 250g - PhP 260.00",
                        "Strawberry Jam 12oz - PhP 280.00")
            }
            position.equals("TEXTILE") -> {
                viewName.text = position
                viewImage.setImageResource(R.drawable.ic_launcher_background)
                products = arrayOf("")
            }
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, products)
        val productsListView = findViewById<ListView>(R.id.albumDetailListView)
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