package com.example.finalproject.data.db.characters

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalproject.data.entities.characters.CharactersDto

@Database(entities = [CharactersDto::class], version = 1)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun getCharactersDao(): CharactersDao
}
