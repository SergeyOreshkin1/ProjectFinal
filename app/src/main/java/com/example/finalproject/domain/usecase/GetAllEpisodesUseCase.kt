package com.example.finalproject.domain.usecase

import com.example.finalproject.data.db.episodes.EpisodesDatabase
import com.example.finalproject.data.entities.episodes.EpisodesDto
import com.example.finalproject.data.repository.RickAndMortyRepository
import javax.inject.Inject

class GetAllEpisodesUseCase @Inject constructor(
    private val repository: RickAndMortyRepository,
    private val episodesDatabase: EpisodesDatabase
) {
    suspend fun getAllEpisodes(page: Int): List<EpisodesDto> {
        val result = repository.getAllEpisodes(page)
        return if (result.isSuccessful) {
            result.body()?.episodes?.let {
                episodesDatabase.getEpisodesDao().addEpisodes(it)
            }
            result.body()?.episodes ?: emptyList()
        } else {
            episodesDatabase.getEpisodesDao().getEpisodes()
        }
    }
}
