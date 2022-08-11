package com.example.finalproject.presentation.characters.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.finalproject.R
import com.example.finalproject.data.entities.characters.CharactersDto
import com.example.finalproject.databinding.CharactersItemLayoutBinding

val diffCallBack = object : DiffUtil.ItemCallback<CharactersDto>() {

    override fun areItemsTheSame(oldItem: CharactersDto, newItem: CharactersDto):
            Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CharactersDto, newItem: CharactersDto):
            Boolean = oldItem == newItem
}

class CharactersAdapter :
    PagingDataAdapter<CharactersDto, CharactersAdapter.CharactersViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            CharactersItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    @SuppressLint("SetTextI18n")
    class CharactersViewHolder(
        private val binding: CharactersItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharactersDto) {
            binding.apply {
                characterName.text = root.resources.getString(R.string.name) + item.name
                characterSpecies.text = root.resources.getString(R.string.species) + item.species
                characterStatus.text = root.resources.getString(R.string.status) + item.status
                characterGender.text = root.resources.getString(R.string.gender) + item.gender
                val image = item.image
                characterImage.load(image) {
                    crossfade(true)
                    crossfade(100)
                }
            }
        }
    }
}
