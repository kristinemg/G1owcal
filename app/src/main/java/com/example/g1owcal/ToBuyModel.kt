package com.example.g1owcal

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class ToBuyModel(var id: String? = " " , var title : String?= "", var items: String?="") {
//    override fun toString(): String {
//        return "$title   $items"
//    }
}
