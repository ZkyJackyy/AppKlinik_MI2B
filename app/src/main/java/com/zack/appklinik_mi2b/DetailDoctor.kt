package com.zack.appklinik_mi2b

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailDoctor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_doctor)


        val namaDoctor = intent.getStringExtra("namaDoctor")
        val Photo = intent.getIntExtra("photoDoctor",0)
        val ahli = intent.getStringExtra("ahli")
        val review = intent.getStringExtra("review")
        val gambarBintang = intent.getIntExtra("photoBintang",0)
        val rating = intent.getStringExtra("rating")

        val txtnama = findViewById<TextView>(R.id.txtnamadoctor)
        val imgphoto = findViewById<ImageView>(R.id.imgdoctor)
        val txtbidang = findViewById<TextView>(R.id.txtbidangdoctor)
        val txtjumlahreview = findViewById<TextView>(R.id.txtjumlahreview)
        val jumlahrating = findViewById<TextView>(R.id.txtjumlahrating)

        txtnama.text = namaDoctor
        imgphoto.setImageResource(Photo)
        txtbidang.text = ahli
        txtjumlahreview.text = review
        jumlahrating.text = rating

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}