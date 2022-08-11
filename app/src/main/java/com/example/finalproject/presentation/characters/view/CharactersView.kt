package com.example.finalproject.presentation.characters.view

import androidx.paging.PagingData
import com.example.finalproject.data.entities.characters.CharactersDto
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CharactersView : MvpView {
    fun swipeRefreshLayoutSettings()
    fun adapterSubmitData(adapterData: PagingData<CharactersDto>)
}
