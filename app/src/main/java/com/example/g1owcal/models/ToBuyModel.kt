package com.example.g1owcal.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class ToBuyModel(var id: String? = " " , var item_title : String?= "", var items: String?="") {
//    override fun toString(): String {
//        return "$title   $items"
//    }
}
