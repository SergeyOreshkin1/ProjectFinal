package com.example.finalproject.presentation.root.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentRootBinding
import com.example.finalproject.presentation.MainActivity
import com.example.finalproject.presentation.characters.view.CharactersFragment
import com.example.finalproject.presentation.episodes.view.EpisodesFragment
import com.example.finalproject.presentation.locations.view.LocationsFragment
import com.example.finalproject.presentation.root.presenter.RootPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RootFragment : MvpAppCompatFragment(), RootView {

    private val presenter by moxyPresenter { RootPresenter() }

    private var _binding: FragmentRootBinding? = null
    private val binding get() = requireNotNull(_binding)

    companion object {
        fun newInstance() = RootFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRootBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreatedDefaults() {
        (requireActivity() as MainActivity).navigateToFragment(
            R.id.rootFragmentContainerView,
            CharactersFragment()
        )
        bottomMenuItemEnable(charactersItem = false, episodesItem = true, locationsItem = true)
    }

    override fun bottomMenuNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.characters -> {
                    (requireActivity() as MainActivity).navigateToFragment(
                        R.id.rootFragmentContainerView,
                        CharactersFragment()
                    )
                    bottomMenuItemEnable(
                        charactersItem = false,
                        episodesItem = true,
                        locationsItem = true
                    )
                }
                R.id.episodes -> {
                    (requireActivity() as MainActivity).navigateToFragment(
                        R.id.rootFragmentContainerView,
                        EpisodesFragment()
                    )
                    bottomMenuItemEnable(
                        charactersItem = true,
                        episodesItem = false,
                        locationsItem = true
                    )
                }
                R.id.locations -> {
                    (requireActivity() as MainActivity).navigateToFragment(
                        R.id.rootFragmentContainerView,
                        LocationsFragment()
                    )
                    bottomMenuItemEnable(
                        charactersItem = true,
                        episodesItem = true,
                        locationsItem = false
                    )
                }
            }
            true
        }
    }

    override fun bottomMenuItemEnable(
        charactersItem: Boolean,
        episodesItem: Boolean,
        locationsItem: Boolean
    ) {
        val charactersMenuItem = binding.bottomNavigation.menu.findItem(R.id.characters)
        charactersMenuItem.isEnabled = charactersItem
        val episodesMenuItem = binding.bottomNavigation.menu.findItem(R.id.episodes)
        episodesMenuItem.isEnabled = episodesItem
        val locationsMenuItem = binding.bottomNavigation.menu.findItem(R.id.locations)
        locationsMenuItem.isEnabled = locationsItem
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
