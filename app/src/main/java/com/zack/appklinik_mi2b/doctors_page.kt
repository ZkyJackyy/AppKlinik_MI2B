package com.zack.appklinik_mi2b

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zack.appklinik_mi2b.Adapter.AdapterDoctor
import com.zack.appklinik_mi2b.Adapter.Adaptermenuicon
import com.zack.appklinik_mi2b.Model.ModelList
import com.zack.appklinik_mi2b.Model.Modelcon

class doctors_page : AppCompatActivity() {

    private lateinit var txtBack : TextView

    private lateinit var RecyclerViewMenu : RecyclerView
    private lateinit var AdapterMenu : Adaptermenuicon

    private lateinit var RecyclerViewDoctor : RecyclerView
    private lateinit var AdapterDoctor : AdapterDoctor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctors_page)


        val menuIcons = listOf(
            Modelcon(R.drawable.icon_heart,"cardiologist"),
            Modelcon(R.drawable.icon_eye,"Ophthalmologyst"),
            Modelcon(R.drawable.icon_tooth,"Dentist")
        )


        //inisialisasi recyclerview dan adapter
        RecyclerViewMenu = findViewById(R.id.recycleViewMenu)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        AdapterMenu = Adaptermenuicon(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        //data untuk dokter
        val menudokter = listOf(
            ModelList("Dr.Floyd Miles",R.drawable.dokter1,"Pediatrics","(123 reviews)","4.9"),
            ModelList("Dr.Guy Hawkins",R.drawable.dokter2,"Dentist","(85 reviews)","4.9"),
            ModelList("Dr.Jane Cooper",R.drawable.dokter3,"Cardiologist","(44 reviews)","4.7"),
            ModelList("Dr.Jacob Jones",R.drawable.dokter4,"Nephrologyst","(101 reviews)","5.0"),
            ModelList("Dr.Savannah Nguyen",R.drawable.dokter5,"Urologist","(168 reviews)","4.8")
        )

        //inisialisasi recycleview dan adapter
        RecyclerViewDoctor = findViewById(R.id.recycleViewDoctor)
        RecyclerViewDoctor.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        AdapterDoctor= AdapterDoctor(menudokter)
        RecyclerViewDoctor.adapter = AdapterDoctor


        txtBack = findViewById(R.id.txtBack)

        txtBack.setOnClickListener(){
            finish()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}