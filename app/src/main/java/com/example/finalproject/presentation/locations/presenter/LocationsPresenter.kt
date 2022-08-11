package com.example.finalproject.presentation.locations.presenter

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.finalproject.domain.usecase.GetAllLocationsUseCase
import com.example.finalproject.presentation.locations.view.LocationsView
import com.example.finalproject.presentation.locations.view.paging.LocationsPagingSource
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class LocationsPresenter @Inject constructor(private val useCase: GetAllLocationsUseCase) :
    MvpPresenter<LocationsView>() {

    val locationsList = Pager(PagingConfig(pageSize = 1)) {
        LocationsPagingSource(useCase)

    }.flow.cachedIn(presenterScope)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            locationsList.collect {
                viewState.adapterSubmitData(it)
            }
        }
        viewState.swipeRefreshLayoutSettings()
    }
}
