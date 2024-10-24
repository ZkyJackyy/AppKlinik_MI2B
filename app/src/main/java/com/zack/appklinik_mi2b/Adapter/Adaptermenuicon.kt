package com.zack.appklinik_mi2b.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zack.appklinik_mi2b.Model.Modelcon
import com.zack.appklinik_mi2b.R

class Adaptermenuicon (
    val itemMenuList : List<Modelcon>
) : RecyclerView.Adapter<Adaptermenuicon.MyviewHolder>(){
    class MyviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgMenuicon : ImageView = itemView.findViewById(R.id.imgMenuicon)
        var txtnamamenu : TextView = itemView.findViewById(R.id.nmMenuicon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemMenuList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemMenuList[position]
        holder.imgMenuicon.setImageResource(currentItem.iconImage)
        holder.txtnamamenu.setText(currentItem.iconName)
    }


}