package com.example.g1owcal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
internal class ProductAdapter(
        private val context: Context,
        private val numbersInWords: Array<String>,
        private val numberImage: IntArray,
        private val productPrice: Array<String>
) :
        BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var textView1: TextView
    override fun getCount(): Int {
        return numbersInWords.size
    }
    override fun getItem(position: Int): Any? {
        return null
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
    ): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.product_display, null)
        }
        imageView = convertView!!.findViewById(R.id.imageView)
        textView = convertView.findViewById(R.id.textView)
        textView1 = convertView.findViewById(R.id.textView1)
        imageView.setImageResource(numberImage[position])
        textView.text = numbersInWords[position]
        textView1.text = productPrice[position]
        return convertView
    }
}