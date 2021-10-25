package com.example.weatherapp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.weatherapp.R

class ViewPagerAdapter(private val pageList: List<ViewPagerItemModel>) : PagerAdapter() {

    private val position: Int = 0

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return LayoutInflater.from(container.context).inflate(pageList[position].layoutId, container, false).apply {
            this.findViewById<TextView>(R.id.city_name_text).text = pageList[position].cityName
            this.findViewById<TextView>(R.id.weather_degree_c_text).text = pageList[position].tempC
            this.findViewById<TextView>(R.id.weather_situation_text).text = pageList[position].degreeText
            this.findViewById<TextView>(R.id.weather_degree_f_text).text = pageList[position].tempF
            this.findViewById<TextView>(R.id.weather_felt_c_text).text = pageList[position].feelsLikeC
            this.findViewById<TextView>(R.id.weather_felt_f_text).text = pageList[position].feelsLikeF
            container.addView(this)
        }
    }

    override fun getCount(): Int {
        return pageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {}
}