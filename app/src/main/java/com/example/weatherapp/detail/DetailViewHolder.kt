package com.example.weatherapp.detail

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.LayoutRecyclerViewItemBinding

class DetailViewHolder(private val binding: LayoutRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DetailModel) {
        binding.model = item
        binding.executePendingBindings()
    }
}