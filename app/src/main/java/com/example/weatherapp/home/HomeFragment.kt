package com.example.weatherapp.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentHomeBinding
import com.example.weatherapp.databinding.LayoutViewPagerItemBinding
import com.example.weatherapp.util.Constants
import kotlinx.android.synthetic.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), TextWatcher, AdapterView.OnItemClickListener {

    private val viewModel by viewModel<HomeFragmentViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private var searchKeyWord: String = ""
    private var pageList: ArrayList<ViewPagerItemModel> = arrayListOf()
    private lateinit var textView: TextView
    private lateinit var viewPagerBinding: LayoutViewPagerItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        binding.homeFragmentAutoCompleteTextview.addTextChangedListener(this)

        binding.homeFragmentAutoCompleteTextview.onItemClickListener = this

        return binding.root
    }

    private fun addNewPageToList(viewPagerItemModel: ViewPagerItemModel) {
        pageList.add(viewPagerItemModel)
        setViewPagerAdapter()
    }

    private fun setViewPagerAdapter() {
        binding.homeFragmentViewPager.adapter = ViewPagerAdapter(pageList)
    }

    private fun getCityList() {
        viewModel.fetchCityListResponse(Constants.API_KEY, searchKeyWord).observe(viewLifecycleOwner, { cities ->
            cities?.let {
                binding.homeFragmentAutoCompleteTextview.setAdapter(ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item, cities.map {
                    it.name
                }))
            }
        })
    }

    private fun getCityCurrentWeather(selected: String) {
        viewModel.fetchCityCurrentResponse(Constants.API_KEY, selected).observe(viewLifecycleOwner, {
            val viewPagerItemModel = ViewPagerItemModel(R.layout.layout_view_pager_item, it.location.region)
            addNewPageToList(viewPagerItemModel)
        })
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        searchKeyWord = binding.homeFragmentAutoCompleteTextview.text.toString()
        if (searchKeyWord.isNotEmpty()) {
            getCityList()
        }
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        searchKeyWord = binding.homeFragmentAutoCompleteTextview.text.toString()
        if (searchKeyWord.isNotEmpty()) {
            getCityList()
        }
    }

    override fun afterTextChanged(p0: Editable?) {
        searchKeyWord = binding.homeFragmentAutoCompleteTextview.text.toString()
        if (searchKeyWord.isNotEmpty()) {
            getCityList()
        }
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val selected: String = p0?.getItemAtPosition(p2).toString()
        getCityCurrentWeather(selected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}