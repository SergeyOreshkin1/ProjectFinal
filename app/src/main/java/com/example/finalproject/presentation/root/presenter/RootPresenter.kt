package com.example.finalproject.presentation.root.presenter

import com.example.finalproject.presentation.root.view.RootView
import moxy.MvpPresenter

class RootPresenter : MvpPresenter<RootView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.onViewCreatedDefaults()
        viewState.bottomMenuNavigation()
    }
}
