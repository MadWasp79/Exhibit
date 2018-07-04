package com.mwhive.exhibitviewer.Application

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.mwhive.exhibitviewer.Application.adapters.ExhibitRecyclerAdapter
import com.mwhive.exhibitviewer.fileexhibitsloader.ExhibitsLoader
import com.mwhive.exhibitviewer.R
import com.mwhive.exhibitviewer.model.Exhibit

class MainActivity : AppCompatActivity() {

    val exhibitLoader : ExhibitsLoader = ExhibitsLoader(this)
    private lateinit var recyclerView: RecyclerView
    private lateinit var exhibitsList: List<Exhibit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exhibitsList = exhibitLoader.getExhibitList()!!
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ExhibitRecyclerAdapter(exhibitsList, this)
    }


}
