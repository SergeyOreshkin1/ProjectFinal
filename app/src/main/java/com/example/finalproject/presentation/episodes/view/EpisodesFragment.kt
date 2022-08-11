package com.example.finalproject.presentation.episodes.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.example.finalproject.R
import com.example.finalproject.data.entities.episodes.EpisodesDto
import com.example.finalproject.databinding.FragmentEpisodesBinding
import com.example.finalproject.presentation.App
import com.example.finalproject.presentation.episodes.presenter.EpisodesPresenter
import com.example.finalproject.presentation.episodes.view.adapter.EpisodesAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenterScope
import javax.inject.Inject
import javax.inject.Provider

class EpisodesFragment : MvpAppCompatFragment(), EpisodesView {

    @Inject
    lateinit var presenterProvider: Provider<EpisodesPresenter>
    private val presenter: EpisodesPresenter by moxyPresenter { presenterProvider.get() }

    private val adapter = EpisodesAdapter()
    private var _binding: FragmentEpisodesBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
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

    override fun adapterSubmitData(adapterData: PagingData<EpisodesDto>) {
        lifecycleScope.launch {
            adapter.submitData(adapterData)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
