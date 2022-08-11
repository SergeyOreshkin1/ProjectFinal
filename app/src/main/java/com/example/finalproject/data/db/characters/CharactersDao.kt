package com.example.finalproject.data.db.characters

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finalproject.data.entities.characters.CharactersDto

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(characters : List<CharactersDto>)

   //  @Query("SELECT * FROM CharactersDto WHERE id >= (:page*20-19) AND id <= (:page*20)")
   //suspend fun getCharacters(page: Int) : List<CharactersDto>
   @Query("SELECT * FROM CharactersDto")
    suspend fun getCharacters() : List<CharactersDto>
}
