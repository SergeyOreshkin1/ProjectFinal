package com.example.finalproject.data.entities.locations

import com.google.gson.annotations.SerializedName

data class LocationsResponse(
    @SerializedName("results") val locations: List<LocationsDto>
)
