package com.burhan.karakurt.weekend.character_list.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.burhan.karakurt.weekend.character_list.R
import com.burhan.karakurt.weekend.character_list.databinding.FragmentCharacterListBinding
import com.burhan.karakurt.weekend.common.base.ui.BaseFragment
import com.burhan.karakurt.weekend.common.util.EndlessRecyclerViewScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : BaseFragment<FragmentCharacterListBinding>() {


    private val characterListViewModel: CharacterListViewModel by viewModels()
    var hasMore = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        setEndlessLayout()
    }


    override fun getLayoutId(): Int = R.layout.fragment_character_list

    private fun setUpViewModel() {
        with(characterListViewModel) {
            getLayoutViewState().observe(viewLifecycleOwner) {
                binding.layoutViewState = it
                binding.executePendingBindings()
                //handle error layout
            }
            getCharacterListViewState().observe(viewLifecycleOwner) {
                binding.characterListViewState = it
                binding.executePendingBindings()
                hasMore = it.getCharacterList().isNotEmpty()
            }
        }
    }

    private fun setEndlessLayout() {
        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.characterListRV.layoutManager = layoutManager
        binding.characterListRV.addOnScrollListener(object :
            EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                if (hasMore) characterListViewModel.getCharacterList(page + 1)
            }
        })
    }

}