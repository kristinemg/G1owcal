package com.example.g1owcal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

class homePage : AppCompatActivity() {

    var categories = arrayOf("BAGS" , "TREATS" , "TEXTILES")
    var images = intArrayOf(R.drawable.ic_launcher_background , R.drawable.ic_launcher_background
            , R.drawable.ic_launcher_background)

    var products = arrayOf("Ube Jam 12 oz", "Peanut Brittle 370g",
            "Strawberry Jam 80z", "Snow Balls 320g", "Cashew Brittle 330g",
            "Cashew Crunch 250g", "Strawberry Jam 12oz")

    var productPrice = arrayOf("PhP 230.00", "PhP 185.00", "PhP 225.00", "PhP 320.00",
                                "PhP 295.00", "PhP 260.00", "PhP 280.00")

    var prod_image =  intArrayOf(R.drawable.ube_jam, R.drawable.peanut_brittle, R.drawable.strawberry_jam,
                        R.drawable.snow_balls, R.drawable.cashew_brittle,
                        R.drawable.cashew_crunch,R.drawable.strawberry_jam_big)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val gridView = findViewById<GridView>(R.id.categoryView)
        val mainAdapter = MainAdapter(this, categories, images)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, productDetails::class.java)
            intent.putExtra("position", categories[position])
            startActivity(intent)
        }

        val prodView = findViewById<GridView>(R.id.prodView)
        val prodAdapter = MainAdapter (this, products,prod_image)
        prodView.adapter = prodAdapter
        prodView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, productListsDetails::class.java)
            intent.putExtra("position", products[position])
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_to_cart, menu)
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
            R.id.to_buy -> {
                val intent = Intent(this, ToBuyList::class.java)
                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_to_cart -> {
                Toast.makeText(this, "Added to Queue", Toast.LENGTH_LONG).show()
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                cartItems.add(productsArray[info.position])
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}

var cartItems = arrayListOf<String>()
val productsArray = arrayOf("")