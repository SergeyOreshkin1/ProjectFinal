package com.example.finalproject.presentation.episodes.presenter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.finalproject.domain.usecase.GetAllEpisodesUseCase
import com.example.finalproject.presentation.episodes.view.EpisodesView
import com.example.finalproject.presentation.episodes.view.paging.EpisodesPagingSource
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class EpisodesPresenter @Inject constructor(private val useCase: GetAllEpisodesUseCase) :
    MvpPresenter<EpisodesView>() {

    private val episodesList = Pager(PagingConfig(pageSize = 1)) {
        EpisodesPagingSource(useCase)

    }.flow.cachedIn(presenterScope)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            episodesList.collect {
                viewState.adapterSubmitData(it)
            }
        }
        viewState.swipeRefreshLayoutSettings()
    }
}
