package com.example.finalproject.di

import com.example.finalproject.data.db.characters.CharactersDatabase
import com.example.finalproject.data.db.episodes.EpisodesDatabase
import com.example.finalproject.data.db.locations.LocationsDatabase
import com.example.finalproject.data.repository.RickAndMortyRepository
import com.example.finalproject.domain.usecase.GetAllCharactersUseCase
import com.example.finalproject.domain.usecase.GetAllEpisodesUseCase
import com.example.finalproject.domain.usecase.GetAllLocationsUseCase
import dagger.Module
import dagger.Provides

@Module
object UseCaseModule {
    @Provides
    fun providesGetAbilitiesUseCase(
        repository: RickAndMortyRepository,
        database: CharactersDatabase
    ): GetAllCharactersUseCase =
        GetAllCharactersUseCase(repository, database)

    @Provides
    fun providesGetAllEpisodes(
        repository: RickAndMortyRepository,
        database: EpisodesDatabase
    ): GetAllEpisodesUseCase =
        GetAllEpisodesUseCase(repository, database)

    @Provides
    fun providesGetAllLocations(
        repository: RickAndMortyRepository,
        database: LocationsDatabase
    ): GetAllLocationsUseCase =
        GetAllLocationsUseCase(repository, database)
}
