package com.example.a994test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class ChildRecyclerViewAdapter (arrayList: ArrayList<ChildModel>, var cxt: Context):
RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder?>(){
    var childNodelArrayList: ArrayList<ChildModel>



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var placeImage: ImageView
        var placeName: TextView

        init {
            placeImage = itemView.findViewById(R.id.places_image)
            placeName = itemView.findViewById(R.id.places_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view: View =
            LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_recyclerview_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        val currentItem: ChildModel = childNodelArrayList[position]
        holder.placeImage.setImageResource(currentItem.placeImage)
        holder.placeName.setText(currentItem.placeName)
    }

     override fun getItemCount(): Int {
         return childNodelArrayList.size
     }

    init {
        childNodelArrayList = arrayList
    }



 }