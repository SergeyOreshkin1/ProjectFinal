package com.example.finalproject.domain.usecase

import com.example.finalproject.data.db.characters.CharactersDatabase
import com.example.finalproject.data.entities.characters.CharactersDto
import com.example.finalproject.data.repository.RickAndMortyRepository
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val repository: RickAndMortyRepository,
    private val charactersDatabase: CharactersDatabase
) {
    suspend fun getAllCharacters(page: Int): List<CharactersDto> {
        val result = repository.getAllCharacters(page)
        return if (result.isSuccessful) {
            result.body()?.characters?.let {
                charactersDatabase.getCharactersDao().addCharacters(it)
            }
            result.body()?.characters ?: emptyList()
        } else {
            charactersDatabase.getCharactersDao().getCharacters()
        }
    }
}
