package com.example.finalproject.data.db.episodes

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalproject.data.entities.episodes.EpisodesDto

@Database(entities = [EpisodesDto::class], version = 1)
abstract class EpisodesDatabase : RoomDatabase() {

    abstract fun getEpisodesDao(): EpisodesDao
}
