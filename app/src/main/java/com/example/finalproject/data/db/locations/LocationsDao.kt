package com.example.finalproject.data.db.locations

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finalproject.data.entities.locations.LocationsDto

@Dao
interface LocationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLocations(locations: List<LocationsDto>)

    @Query("SELECT * FROM LocationsDto")
    suspend fun getLocations(): List<LocationsDto>
}