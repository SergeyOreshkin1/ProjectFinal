package com.example.finalproject.data.db.episodes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finalproject.data.entities.episodes.EpisodesDto

@Dao
interface EpisodesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEpisodes(episodes : List<EpisodesDto>)

    @Query("SELECT * FROM EpisodesDto")
    suspend fun getEpisodes() : List<EpisodesDto>
}