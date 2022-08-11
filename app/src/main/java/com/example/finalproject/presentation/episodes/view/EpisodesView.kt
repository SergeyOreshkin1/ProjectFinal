package com.example.finalproject.presentation.episodes.view

import androidx.paging.PagingData
import com.example.finalproject.data.entities.episodes.EpisodesDto
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface EpisodesView : MvpView {
    fun swipeRefreshLayoutSettings()
    fun adapterSubmitData(adapterData: PagingData<EpisodesDto>)
}
