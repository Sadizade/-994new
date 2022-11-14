package com.example.a994test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    private lateinit var parentRecyclerView: RecyclerView
    private var ParentAdapter: RecyclerView.Adapter<*>? = null
    var parentModelArrayList: ArrayList<ParentModel> = ArrayList()
    private var parentLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        parentModelArrayList.add(ParentModel("Popular Places"))
        parentModelArrayList.add(ParentModel("Popular Tags"))
        parentModelArrayList.add(ParentModel("Last Seen"))
        parentRecyclerView = findViewById(R.id.Parent_RecycelerView)
        parentRecyclerView.setHasFixedSize(true)
        parentLayoutManager = LinearLayoutManager(this)
        ParentAdapter = ParentRecyclerViewAdapter(parentModelArrayList, this@MainActivity)
        parentRecyclerView.setLayoutManager(parentLayoutManager)
        parentRecyclerView.setAdapter(ParentAdapter)
        (ParentAdapter as ParentRecyclerViewAdapter).notifyDataSetChanged()
    }
}