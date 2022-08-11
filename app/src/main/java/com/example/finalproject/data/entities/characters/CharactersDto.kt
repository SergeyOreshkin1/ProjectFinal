package com.example.finalproject.data.entities.characters

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class CharactersDto(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String
)
