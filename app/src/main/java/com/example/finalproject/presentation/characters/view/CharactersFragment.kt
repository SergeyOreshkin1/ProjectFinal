package com.example.finalproject.presentation.characters.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.example.finalproject.R
import com.example.finalproject.data.entities.characters.CharactersDto
import com.example.finalproject.data.entities.episodes.EpisodesDto
import com.example.finalproject.databinding.FragmentCharactersBinding
import com.example.finalproject.presentation.App
import com.example.finalproject.presentation.characters.view.adapter.CharactersAdapter
import com.example.finalproject.presentation.characters.presenter.CharactersPresenter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenterScope
import javax.inject.Inject
import javax.inject.Provider

class CharactersFragment : MvpAppCompatFragment(), CharactersView {

    @Inject
    lateinit var presenterProvider: Provider<CharactersPresenter>
    private val presenter: CharactersPresenter by moxyPresenter { presenterProvider.get() }

    private val adapter = CharactersAdapter()
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
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

    override fun adapterSubmitData(adapterData: PagingData<CharactersDto>) {
        lifecycleScope.launch {
            adapter.submitData(adapterData)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
