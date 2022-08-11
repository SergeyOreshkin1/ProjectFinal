package com.example.finalproject.di

import com.example.finalproject.data.repository.RickAndMortyRepository
import com.example.finalproject.data.repository.RickAndMortyRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsRickAndMortyRepository(implementation: RickAndMortyRepositoryImpl): RickAndMortyRepository
}
