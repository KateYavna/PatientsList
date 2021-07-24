package com.example.patientslist

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_patient.view.*

class PatientsAdapter(val patients : ArrayList<Patient>, val context:Context,val callBack: PatientsListCallBack)
    :RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_patient,parent,false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.sex.text = patients[position].sex
        holder.name.text = patients[position].name
        holder.lastName.text = patients[position].lastName
        holder.age.text = patients[position].age
        holder.root.setOnClickListener{callBack.onItemSelected(position)}
    }

    override fun getItemCount(): Int {
      return patients.size
    }

}




class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){

    val sex = itemView.tvSexList
    val name = itemView.tvNameList
    val lastName = itemView.tvLastNameList
    val age = itemView.tvAgeList
    val root = itemView.clItemRoot
}

interface PatientsListCallBack{
    fun onItemSelected(index:Int)
}