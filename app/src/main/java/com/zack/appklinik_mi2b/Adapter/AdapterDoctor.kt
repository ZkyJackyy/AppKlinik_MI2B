package com.zack.appklinik_mi2b.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.zack.appklinik_mi2b.DetailDoctor
import com.zack.appklinik_mi2b.Model.ModelList
import com.zack.appklinik_mi2b.R

class AdapterDoctor (
    val itemDoctor : List<ModelList>
) : RecyclerView.Adapter<AdapterDoctor.MyviewHolder>() {
    class MyviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgdoctor : ImageView = itemView.findViewById(R.id.imgdoctor)
        var txtnamadoctor : TextView = itemView.findViewById(R.id.txtnamadoctor)
        var txtbidang : TextView = itemView.findViewById(R.id.txtbidangdoctor)
        var txtjumlahreview : TextView = itemView.findViewById(R.id.txtjumlahreview)
        var txtjumlahrating : TextView = itemView.findViewById(R.id.txtjumlahrating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context).inflate(R.layout.item_doktor,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctor.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemDoctor[position]
        holder.imgdoctor.setImageResource(currentItem.imageDr)
        holder.txtnamadoctor.setText(currentItem.namaDr)
        holder.txtbidang.setText(currentItem.bidangDr)
        holder.txtjumlahreview.setText(currentItem.totalReview)
        holder.txtjumlahrating.setText(currentItem.angkaReview)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailDoctor::class.java).apply {
                // Mengirim data melalui intent
                putExtra("namaDoctor", currentItem.namaDr)
                putExtra("photoDoctor", currentItem.imageDr)
                putExtra("ahli", currentItem.bidangDr)
                putExtra("review", currentItem.totalReview)
                putExtra("rating", currentItem.angkaReview)

            }
            context.startActivity(intent)
        }

    }


}