package com.example.poo9

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SmartPhoneAdapter(context: Context , private val smartphone: ArrayList<Smartphone>):ArrayAdapter<Smartphone>(context, 0 , smartphone) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val ListeItemview = LayoutInflater.from(context).inflate(R.layout.item, parent, false)

        val currentSmartPhone = smartphone[position]

        val imageView = ListeItemview.findViewById<ImageView>(R.id.img)
        Glide.with(context)
            .load(currentSmartPhone.image)
            .into(imageView)

        val name_txt = ListeItemview.findViewById<TextView>(R.id.txt_info)
        name_txt.text = currentSmartPhone.name

        return ListeItemview
    }
}