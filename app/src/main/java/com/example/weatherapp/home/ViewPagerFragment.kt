package com.example.weatherapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.layout_view_pager_item.view.*

class ViewPagerFragment : Fragment() {
    private var textFragment = ""

    companion object {
        fun newInstance(text: String): ViewPagerFragment {
            val fragment = ViewPagerFragment()
            val bundle = Bundle()
            bundle.putString("AddFragment", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textFragment = arguments?.get("AddFragment").toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_view_pager_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.city_name_text.text = textFragment
    }
}