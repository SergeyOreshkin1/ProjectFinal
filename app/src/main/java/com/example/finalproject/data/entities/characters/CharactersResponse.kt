package com.example.finalproject.data.entities.characters

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("results") val characters: List<CharactersDto>,
    val pages: Int
)
