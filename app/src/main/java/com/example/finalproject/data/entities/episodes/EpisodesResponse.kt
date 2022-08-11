package com.example.finalproject.data.entities.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesResponse(
    @SerializedName("results") val episodes: List<EpisodesDto>
)
