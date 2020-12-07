package com.example.g1owcal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.g1owcal.handlers.ItemTableHandler
import com.example.g1owcal.models.ToBuyModel
import java.lang.Exception

class AddToBuyItems : AppCompatActivity() {

    lateinit var doneButton: Button
    lateinit var titleET: EditText
    lateinit var itemsET: EditText
    lateinit var channelHandler: ItemTableHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_buy_items)

        titleET = findViewById(R.id.titleList)
        itemsET = findViewById(R.id.itemsOnList)
        channelHandler = ItemTableHandler()
        doneButton = findViewById(R.id.AddBtn)

        doneButton.setOnClickListener{
            val title = titleET.text.toString()
            val item = itemsET.text.toString()

            try {
                val channel = ToBuyModel(item_title = title, items = item)
                if (channelHandler.create(channel)) {
                Toast.makeText(this,"Added successfully!", Toast.LENGTH_SHORT).show()
                clearFields()
            }
        }catch (e: Exception){
            Toast.makeText(this,"Failed to add!", Toast.LENGTH_LONG).show()
        }}
    }

    private fun clearFields(){
        titleET.text.clear()
        itemsET.text.clear()
    }
}