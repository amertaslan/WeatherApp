package com.example.weatherapp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.weatherapp.R

class ViewPagerAdapter(private val pageList: List<ViewPagerItemModel>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return LayoutInflater.from(container.context).inflate(pageList[position].layoutId, container, false).apply {
            this.findViewById<TextView>(R.id.city_name_text).text = pageList[position].cityName
            this.findViewById<TextView>(R.id.weather_degree_text).text = pageList[position].degree
            container.addView(this)
            notifyDataSetChanged()
        }
    }

    override fun getCount(): Int {
        return pageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeAllViews()
        notifyDataSetChanged()
    }
}