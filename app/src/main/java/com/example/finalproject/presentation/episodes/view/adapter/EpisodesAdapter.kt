package com.example.finalproject.presentation.episodes.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.entities.episodes.EpisodesDto
import com.example.finalproject.databinding.EpisodesItemLayoutBinding

private val diffCallBack = object : DiffUtil.ItemCallback<EpisodesDto>() {

    override fun areItemsTheSame(oldItem: EpisodesDto, newItem: EpisodesDto):
            Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: EpisodesDto, newItem: EpisodesDto):
            Boolean = oldItem == newItem
}

class EpisodesAdapter :
    PagingDataAdapter<EpisodesDto, EpisodesAdapter.EpisodesViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder(
            EpisodesItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    @SuppressLint("SetTextI18n")
    class EpisodesViewHolder(
        private val binding: EpisodesItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EpisodesDto) {
            binding.apply {
                episodeName.text = root.resources.getString(R.string.episodeName) + item.name
                episodeNumber.text = root.resources.getString(R.string.episodeNumber) + item.episode
                episodeDate.text = root.resources.getString(R.string.airDate) + item.airDate
            }
        }
    }
}
