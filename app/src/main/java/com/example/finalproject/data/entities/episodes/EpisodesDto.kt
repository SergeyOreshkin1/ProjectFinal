package com.example.finalproject.data.entities.episodes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class EpisodesDto(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val episode: String,
    @SerializedName("air_date") val airDate: String
)
