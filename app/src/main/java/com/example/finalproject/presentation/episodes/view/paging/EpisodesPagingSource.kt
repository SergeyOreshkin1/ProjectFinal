package com.example.finalproject.presentation.episodes.view.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.finalproject.data.entities.episodes.EpisodesDto
import com.example.finalproject.domain.usecase.GetAllEpisodesUseCase
import javax.inject.Inject

class EpisodesPagingSource @Inject
constructor(
    private val useCase: GetAllEpisodesUseCase
) : PagingSource<Int, EpisodesDto>() {

    override fun getRefreshKey(state: PagingState<Int, EpisodesDto>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, EpisodesDto> {

        return try {
            val currentPage = params.key ?: 1
            val response = useCase.getAllEpisodes(currentPage)
            val responseData = mutableListOf<EpisodesDto>()
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
