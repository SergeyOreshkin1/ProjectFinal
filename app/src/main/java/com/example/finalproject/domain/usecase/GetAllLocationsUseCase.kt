package com.example.finalproject.domain.usecase

import com.example.finalproject.data.db.locations.LocationsDatabase
import com.example.finalproject.data.entities.locations.LocationsDto
import com.example.finalproject.data.repository.RickAndMortyRepository
import javax.inject.Inject

class GetAllLocationsUseCase @Inject constructor(
    private val repository: RickAndMortyRepository,
    private val locationsDatabase: LocationsDatabase
) {
    suspend fun getAllLocations(page: Int): List<LocationsDto> {
        val result = repository.getAllLocations(page)
        return if (result.isSuccessful) {
            result.body()?.locations?.let {
                locationsDatabase.getLocationsDao().addLocations(it)
            }
            result.body()?.locations ?: emptyList()
        } else {
            locationsDatabase.getLocationsDao().getLocations()
        }
    }
}
