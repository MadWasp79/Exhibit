package com.mwhive.exhibitviewer.Application.adapters

import android.content.ClipData
import android.content.Context
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mwhive.exhibitviewer.R
import com.mwhive.exhibitviewer.model.Exhibit


/**
 * Created by MadWasp79 on 04-Jul-18.
 */

class ExhibitRecyclerAdapter (
        val exhibits: List<Exhibit>,
        val ctx : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.rc_list_element, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = exhibits.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bind(exhibits.get(position).images, exhibits.get(position).title, holder)
    }

    fun bind (images:List<String>, title: String, holder: RecyclerView.ViewHolder){
        (holder as MyViewHolder).vpager.adapter = ExhibitViewPagerAdapter(images, title, ctx)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vpager = itemView.findViewById(R.id.view_pager) as ViewPager
    }
}
