package com.example.finalproject.di

import android.content.Context
import com.example.finalproject.presentation.characters.view.CharactersFragment
import com.example.finalproject.presentation.episodes.view.EpisodesFragment
import com.example.finalproject.presentation.locations.view.LocationsFragment
import com.example.finalproject.presentation.root.view.RootFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, UseCaseModule::class, RepositoryModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun inject(fragment: RootFragment)
    fun inject(fragment: CharactersFragment)
    fun inject(fragment: LocationsFragment)
    fun inject(fragment: EpisodesFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}
