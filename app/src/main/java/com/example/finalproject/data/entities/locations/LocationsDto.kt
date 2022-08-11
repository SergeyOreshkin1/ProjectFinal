package com.example.finalproject.data.entities.locations

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationsDto(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)
