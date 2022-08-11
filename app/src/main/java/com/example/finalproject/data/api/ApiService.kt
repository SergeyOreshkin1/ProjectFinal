package com.example.finalproject.data.api

import com.example.finalproject.data.entities.characters.CharactersResponse
import com.example.finalproject.data.entities.episodes.EpisodesResponse
import com.example.finalproject.data.entities.locations.LocationsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<CharactersResponse>

    @GET("episode")
    suspend fun getAllEpisodes(
        @Query("page") page: Int
    ): Response<EpisodesResponse>

    @GET("location")
    suspend fun getAllLocations(
        @Query("page") page: Int
    ): Response<LocationsResponse>
}
