package com.example.finalproject.presentation.locations.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.example.finalproject.R
import com.example.finalproject.data.entities.locations.LocationsDto
import com.example.finalproject.databinding.FragmentLocationsBinding
import com.example.finalproject.presentation.App
import com.example.finalproject.presentation.locations.presenter.LocationsPresenter
import com.example.finalproject.presentation.locations.view.adapter.LocationsAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class LocationsFragment : MvpAppCompatFragment(), LocationsView {

    @Inject
    lateinit var presenterProvider: Provider<LocationsPresenter>
    private val presenter: LocationsPresenter by moxyPresenter { presenterProvider.get() }

    private val adapter = LocationsAdapter()
    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
    }

    override fun swipeRefreshLayoutSettings() {
        binding.apply {
            itemsSwipeToRefresh.setProgressBackgroundColorSchemeColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.cyan_color
                )
            )
            itemsSwipeToRefresh.setColorSchemeColors(Color.WHITE)

            itemsSwipeToRefresh.setOnRefreshListener {
                lifecycleScope.launch {
                    delay(1000)
                    adapter.refresh()
                    itemsSwipeToRefresh.isRefreshing = false
                }
            }
        }
    }

    override fun adapterSubmitData(adapterData: PagingData<LocationsDto>) {
        lifecycleScope.launch {
            adapter.submitData(adapterData)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
