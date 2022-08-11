package com.example.finalproject.presentation.locations.view.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.finalproject.data.entities.locations.LocationsDto
import com.example.finalproject.domain.usecase.GetAllLocationsUseCase
import javax.inject.Inject

class LocationsPagingSource @Inject
constructor(
    private val useCase: GetAllLocationsUseCase
) : PagingSource<Int, LocationsDto>() {

    override fun getRefreshKey(state: PagingState<Int, LocationsDto>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, LocationsDto> {

        return try {
            val currentPage = params.key ?: 1
            val response = useCase.getAllLocations(currentPage)
            val responseData = mutableListOf<LocationsDto>()
            responseData.addAll(response)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
