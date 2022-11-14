package com.example.a994test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

 class ParentRecyclerViewAdapter (exampleList: ArrayList<ParentModel>, context: Context):
RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder?>(){
    private val parentModelArrayList: ArrayList<ParentModel>
    private var cxt: Context

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var category: TextView
        var childRecyclerView: RecyclerView

        init {
            category = itemView.findViewById(R.id.Places_Category)
            childRecyclerView = itemView.findViewById(R.id.Child_RV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val view: View =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recyclerview_items, parent, false)
        return  MyViewHolder(view)
    }

     override fun getItemCount(): Int{
         return parentModelArrayList.size
     }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        val currentItem: ParentModel = parentModelArrayList[position]
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false)
        holder.childRecyclerView.setLayoutManager(layoutManager)
        holder.childRecyclerView.setHasFixedSize(true)
        holder.category.setText(currentItem.placeCategory())
        val arrayList: ArrayList<ChildModel> = ArrayList()


        if (parentModelArrayList[position].placeCategory().equals("Popular Places")){
            arrayList.add(ChildModel(R.drawable.azal, "Azerbaijan Airlines"))
            arrayList.add(ChildModel(R.drawable.mcdonalds, "McDonald's"))
            arrayList.add(ChildModel(R.drawable.paulaner, "Paulaner"))

        }

        if (parentModelArrayList[position].placeCategory().equals("Popular Tags")){
            arrayList.add(ChildModel(R.drawable.azal, "Azerbaijan Airlines"))
            arrayList.add(ChildModel(R.drawable.mcdonalds, "McDonald's"))
            arrayList.add(ChildModel(R.drawable.paulaner, "Paulaner"))

        }

        if (parentModelArrayList[position].placeCategory().equals("Last Seen")){
            arrayList.add(ChildModel(R.drawable.azal, "Azerbaijan Airlines"))
            arrayList.add(ChildModel(R.drawable.mcdonalds, "McDonald's"))
            arrayList.add(ChildModel(R.drawable.paulaner, "Paulaner"))

        }

        val childRecyclerViewAdapter = ChildRecyclerViewAdapter(arrayList, holder.childRecyclerView.getContext())
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter)
    }

    init {
        parentModelArrayList = exampleList
        cxt = context
    }

 }