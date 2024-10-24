package com.zack.appklinik_mi2b

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class page_login : AppCompatActivity() {

    private lateinit var txtreg :TextView
    private lateinit var btnlog : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_login)

        txtreg= findViewById(R.id.txtreg)
        btnlog = findViewById(R.id.btnlog)

        txtreg.setOnClickListener(){
            val intent = Intent(this,register_page::class.java)
            startActivity(intent)
        }
        btnlog.setOnClickListener(){
            val intent = Intent(this,doctors_page::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}