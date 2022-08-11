package com.example.finalproject.data.repository

import com.example.finalproject.data.api.ApiService
import com.example.finalproject.data.entities.characters.CharactersResponse
import com.example.finalproject.data.entities.episodes.EpisodesResponse
import com.example.finalproject.data.entities.locations.LocationsResponse
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(private val rickAndMortyAPI: ApiService) :
    RickAndMortyRepository {
    override suspend fun getAllCharacters(page: Int): Response<CharactersResponse> {
        return rickAndMortyAPI.getAllCharacters(page)
    }

    override suspend fun getAllEpisodes(page: Int): Response<EpisodesResponse> {
        return rickAndMortyAPI.getAllEpisodes(page)
    }

    override suspend fun getAllLocations(page: Int): Response<LocationsResponse> {
        return rickAndMortyAPI.getAllLocations(page)
    }
}
