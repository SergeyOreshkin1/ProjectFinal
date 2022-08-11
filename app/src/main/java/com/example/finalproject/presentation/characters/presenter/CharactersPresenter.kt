package com.example.finalproject.presentation.characters.presenter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.finalproject.domain.usecase.GetAllCharactersUseCase
import com.example.finalproject.presentation.characters.view.paging.CharactersPagingSource
import com.example.finalproject.presentation.characters.view.CharactersView
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class CharactersPresenter @Inject constructor(private val useCase: GetAllCharactersUseCase) :
    MvpPresenter<CharactersView>() {

    val charactersList = Pager(PagingConfig(pageSize = 1)) {
        CharactersPagingSource(useCase)

    }.flow.cachedIn(presenterScope)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            charactersList.collect {
                viewState.adapterSubmitData(it)
            }
        }
        viewState.swipeRefreshLayoutSettings()
    }
}
