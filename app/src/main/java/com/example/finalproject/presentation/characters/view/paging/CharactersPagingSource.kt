package com.example.finalproject.presentation.characters.view.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.finalproject.data.entities.characters.CharactersDto
import com.example.finalproject.domain.usecase.GetAllCharactersUseCase
import javax.inject.Inject

class CharactersPagingSource @Inject
constructor(
    private val useCase: GetAllCharactersUseCase
) : PagingSource<Int, CharactersDto>() {

    override fun getRefreshKey(state: PagingState<Int, CharactersDto>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, CharactersDto> {
        return try {
            val currentPage = params.key ?: 1
            val response = useCase.getAllCharacters(currentPage)
            val responseData = mutableListOf<CharactersDto>()
            responseData.addAll(response)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
               // nextKey = if (currentPage <= 42) currentPage.plus(1) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
