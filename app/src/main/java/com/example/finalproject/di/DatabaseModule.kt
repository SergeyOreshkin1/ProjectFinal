package com.example.finalproject.di

import android.content.Context
import androidx.room.Room
import com.example.finalproject.data.db.characters.CharactersDatabase
import com.example.finalproject.data.db.episodes.EpisodesDatabase
import com.example.finalproject.data.db.locations.LocationsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideCharactersDatabase(context: Context): CharactersDatabase {
        return Room.databaseBuilder(context, CharactersDatabase::class.java, "CharactersDatabase")
            .build()
    }

    @Singleton
    @Provides
    fun provideEpisodesDatabase(context: Context): EpisodesDatabase {
        return Room.databaseBuilder(context, EpisodesDatabase::class.java, "EpisodesDatabase")
            .build()
    }

    @Singleton
    @Provides
    fun provideLocationsDatabase(context: Context): LocationsDatabase {
        return Room.databaseBuilder(context, LocationsDatabase::class.java, "LocationsDatabase")
            .build()
    }
}
