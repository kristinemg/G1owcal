package com.example.g1owcal.handlers

import com.example.g1owcal.models.ToBuyModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ItemTableHandler{
    var db : FirebaseDatabase = FirebaseDatabase.getInstance()
    var channelRef : DatabaseReference

    init {
        channelRef = db.getReference("Items")
    }

    fun create(ytList: ToBuyModel): Boolean{
        val id = channelRef.push().key
        ytList.id = id

        channelRef.child(id!!).setValue(ytList)
        return true
    }

    fun delete(ytId: String){
        channelRef.child(ytId).removeValue()
    }

    fun edit(ytList: ToBuyModel): Boolean{
        channelRef.child(ytList.id!!).setValue(ytList)
        return true
    }

    fun add (ytList: ToBuyModel): Boolean{
        val id = channelRef.push().key
        ytList.id = id

        channelRef.child(id!!).setValue(ytList)
        return true
    }

}