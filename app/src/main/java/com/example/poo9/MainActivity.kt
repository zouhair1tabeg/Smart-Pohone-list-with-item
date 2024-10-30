package com.example.poo9

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import javax.microedition.khronos.opengles.GL

data class Smartphone(
    val id : Int,
    val name : String,
    val prix : Int,
    val image : String
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val s1 = Smartphone(1 , "iPhone 16" , 8900 , "https://cdn.yenicaggazetesi.com.tr/news/1112528.jpg")
        val s2 = Smartphone(2 , "Sammsung s24 ultra" , 7500 , "https://th.bing.com/th/id/OIP.LhG7XVTSgYz420P_723mjgHaE8?rs=1&pid=ImgDetMain")

        val LS = ArrayList<Smartphone>()

        LS.add(s1)
        LS.add(s2)

        val lv = findViewById<ListView>(R.id.lv)

        val adapter = SmartPhoneAdapter(this, LS)
        lv.adapter = adapter

        lv.setOnItemClickListener{parent, view, position, id ->
            val phone = LS[position]

            val imv = findViewById<ImageView>(R.id.imgview)
            Glide.with(this)
                .load(phone.image)
                .into(imv)

            val txt_prix = findViewById<TextView>(R.id.prix)
            txt_prix.text = "Price : ${phone.prix} MAD"
        }

    }
}