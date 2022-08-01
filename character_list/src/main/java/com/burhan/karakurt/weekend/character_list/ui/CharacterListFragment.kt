package com.burhan.karakurt.weekend.character_list.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.burhan.karakurt.weekend.character_list.R
import com.burhan.karakurt.weekend.character_list.databinding.FragmentCharacterListBinding
import com.burhan.karakurt.weekend.character_list.ui.adapter.CharacterListAdapter
import com.burhan.karakurt.weekend.character_list.ui.adapter.ItemAdapterClickListener
import com.burhan.karakurt.weekend.common.base.data.State
import com.burhan.karakurt.weekend.common.base.ui.BaseFragment
import com.burhan.karakurt.weekend.common.base.ui.LayoutViewState
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterListFragment : BaseFragment<FragmentCharacterListBinding>(),
    ItemAdapterClickListener {


    private val characterListViewModel: CharacterListViewModel by viewModels()
    private var adapter = CharacterListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.layoutViewState = LayoutViewState(State.Loading)
        binding.executePendingBindings()
        setUpViewModel()
        setUpLayoutManagerLayout()
        binding.characterListRV.adapter = adapter
        adapter.addClickListener(this@CharacterListFragment)
    }


    override fun getLayoutId(): Int = R.layout.fragment_character_list

    private fun setUpViewModel() {
        with(characterListViewModel) {
            getLayoutViewState().observe(viewLifecycleOwner) {
                binding.layoutViewState = it
                binding.executePendingBindings()
                //handle error layout
                Toast.makeText(requireContext(), it.getErrorMessage(requireContext()), Toast.LENGTH_LONG)
                    .show()
            }
            lifecycleScope.launch {
                fetchCharacterListFlow().collect {
                    binding.layoutViewState = LayoutViewState(State.Success(null))
                    adapter.submitData(it)
                    binding.executePendingBindings()
                }
            }
        }
    }

    private fun setUpLayoutManagerLayout() {
        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.characterListRV.layoutManager = layoutManager
    }

    override fun onClickItem(characterModel: MarvelCharacterModel) {
        Toast.makeText(requireContext(), characterModel.name, Toast.LENGTH_LONG)
            .show()
    }

}