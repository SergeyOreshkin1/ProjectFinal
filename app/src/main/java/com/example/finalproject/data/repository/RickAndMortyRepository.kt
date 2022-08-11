package com.example.finalproject.data.repository

import com.example.finalproject.data.entities.characters.CharactersResponse
import com.example.finalproject.data.entities.episodes.EpisodesResponse
import com.example.finalproject.data.entities.locations.LocationsResponse
import retrofit2.Response

interface RickAndMortyRepository {
    suspend fun getAllCharacters(page: Int): Response<CharactersResponse>
    suspend fun getAllEpisodes(page: Int): Response<EpisodesResponse>
    suspend fun getAllLocations(page: Int): Response<LocationsResponse>
}
