package com.mwhive.exhibitviewer.Application.adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mwhive.exhibitviewer.R


/**
 * Created by MadWasp79 on 04-Jul-18.
 */

class ExhibitViewPagerAdapter (
        private val images: List<String>,
        private val title: String,
        private val context :Context) : PagerAdapter() {

    lateinit var layoutInflater:LayoutInflater

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = layoutInflater.inflate(R.layout.exhibit_list_element, container, false)
        val iv = itemView.findViewById(R.id.image_to_slide) as ImageView
        val tv = itemView.findViewById(R.id.image_title) as TextView
        Glide.with(container.context).load(images[position]).into(iv)
        tv.text = title
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return images.size
    }
}