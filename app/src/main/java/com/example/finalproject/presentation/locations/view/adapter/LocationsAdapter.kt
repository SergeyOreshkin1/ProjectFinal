package com.example.finalproject.presentation.locations.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.entities.locations.LocationsDto
import com.example.finalproject.databinding.LocationsItemLayoutBinding

private val diffCallBack = object : DiffUtil.ItemCallback<LocationsDto>() {

    override fun areItemsTheSame(oldItem: LocationsDto, newItem: LocationsDto):
            Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: LocationsDto, newItem: LocationsDto):
            Boolean = oldItem == newItem
}

class LocationsAdapter :
    PagingDataAdapter<LocationsDto, LocationsAdapter.LocationsViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        return LocationsViewHolder(
            LocationsItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    @SuppressLint("SetTextI18n")
    class LocationsViewHolder(
        private val binding: LocationsItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LocationsDto) {
            binding.apply {
                locationName.text = root.resources.getString(R.string.locationName) + item.name
                locationType.text = root.resources.getString(R.string.type) + item.type
                locationDimension.text = root.resources.getString(R.string.dimension) + item.dimension
            }
        }
    }
}
