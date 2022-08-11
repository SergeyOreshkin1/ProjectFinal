package com.example.finalproject.data.db.locations

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalproject.data.entities.locations.LocationsDto

@Database(entities = [LocationsDto::class], version = 1)
abstract class LocationsDatabase : RoomDatabase() {

    abstract fun getLocationsDao(): LocationsDao
}
