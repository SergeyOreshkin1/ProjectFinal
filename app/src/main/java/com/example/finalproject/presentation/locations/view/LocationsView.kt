package com.example.finalproject.presentation.locations.view

import androidx.paging.PagingData
import com.example.finalproject.data.entities.locations.LocationsDto
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface LocationsView : MvpView {
    fun swipeRefreshLayoutSettings()
    fun adapterSubmitData(adapterData: PagingData<LocationsDto>)
}
