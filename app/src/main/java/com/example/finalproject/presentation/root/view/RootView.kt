package com.example.finalproject.presentation.root.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface RootView : MvpView {
    fun onViewCreatedDefaults()
    fun bottomMenuNavigation()
    fun bottomMenuItemEnable(
        charactersItem: Boolean,
        episodesItem: Boolean,
        locationsItem: Boolean
    )
}
