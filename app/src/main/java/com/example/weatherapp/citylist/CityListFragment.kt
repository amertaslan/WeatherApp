package com.example.weatherapp.citylist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCityListBinding
import com.example.weatherapp.util.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityListFragment : Fragment(), TextWatcher, AdapterView.OnItemClickListener {

    private val viewModel by viewModel<CityListViewModel>()
    private lateinit var binding: FragmentCityListBinding
    private var searchKeyWord: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityListBinding.inflate(inflater)

        binding.homeFragmentAutoCompleteTextview.addTextChangedListener(this)

        binding.homeFragmentAutoCompleteTextview.onItemClickListener = this

        return binding.root
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

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        searchKeyWord = binding.homeFragmentAutoCompleteTextview.text.toString()
        if (searchKeyWord.length >= 2) {
            getCityList()
        }
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        searchKeyWord = binding.homeFragmentAutoCompleteTextview.text.toString()
        if (searchKeyWord.length >= 2) {
            getCityList()
        }
    }

    override fun afterTextChanged(p0: Editable?) {
        searchKeyWord = binding.homeFragmentAutoCompleteTextview.text.toString()
        if (searchKeyWord.length >= 2) {
            getCityList()
        }
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val selected = p0?.getItemAtPosition(p2)
        binding.deneme.text = selected.toString()
    }
}