package com.example.g1owcal

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ToBuyList : AppCompatActivity() {

    lateinit var channelListView: ListView
    var itemsOnList = arrayListOf<ToBuyModel>()
    lateinit var itemTableHandler: ItemTableHandler
    lateinit var adapter : arrayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_buy_list)

        channelListView = findViewById(R.id.items_to_buy)
        itemTableHandler = ItemTableHandler()


        channelListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val inflater = this.layoutInflater
                val view = inflater.inflate(R.layout.show_item_info,null)
                val ytSelected = itemsOnList[position]
                val ytlink = ytSelected.item_title
                val ytReason = ytSelected.items
                val resTxt = view.findViewById<TextView>(R.id.reasonDisplay)
                val linkTxt = view.findViewById<TextView>(R.id.linkDisplay)
                linkTxt.text = ytlink
                resTxt.text = ytReason.toString()
                val dialogBuilder = AlertDialog.Builder(this)
                    .setView(view)
                    .setNegativeButton("OK", DialogInterface.OnClickListener { _, _ ->
                    })
                dialogBuilder.create()
                dialogBuilder.show()
            }
    }


    override fun onStart() {
        super.onStart()
        itemTableHandler.channelRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                itemsOnList.clear()
                snapshot.children.forEach{
                        it -> val itemList = it.getValue(ToBuyModel::class.java)
                    itemsOnList.add(itemList!!)
//                    itemsOnList.sortBy { it.rank }
                }
                adapter = arrayAdapter(applicationContext, R.layout.item_list_layout,itemsOnList)
//                val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_expandable_list_item_1,ytChannels)
                channelListView.adapter = adapter
            }
            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.add_to_list, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val yt = itemsOnList[info.position]
        val ytID = yt.id.toString()
        return when(item.itemId){
            R.id.add_to_list ->{
                itemTableHandler.delete(ytID)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}