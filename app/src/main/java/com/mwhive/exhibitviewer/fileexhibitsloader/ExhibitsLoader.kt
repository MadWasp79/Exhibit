package com.mwhive.exhibitviewer.fileexhibitsloader

import android.content.Context
import com.mwhive.exhibitviewer.model.Exhibit
import com.mwhive.exhibitviewer.model.IExhibitsLoader
import com.mwhive.exhibitviewer.R
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi


/**
 * Created by MadWasp79 on 04-Jul-18.
 */

class ExhibitsLoader (private val context: Context) : IExhibitsLoader {

    override fun getExhibitList() : List<Exhibit>? {
        val rawJsonString = context.resources.openRawResource(R.raw.stub)
                .bufferedReader().use { it.readText() }

        //This is a not optimal solution, but since you explicitly told me which files to create,
        // I 'extracted' json array from object before parsing.

        val firstSqrBracket = rawJsonString.indexOf('[', 0, true)
        val jsonArray = rawJsonString.substring(firstSqrBracket, rawJsonString.lastIndex)

        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        val exhibitAdapter = moshi.adapter<Array<Exhibit>>(Array<Exhibit>::class.java)

        return exhibitAdapter.fromJson(jsonArray)!!.toList()
    }

}