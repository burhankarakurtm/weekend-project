package com.burhan.karakurt.weekend.character_list.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.burhan.karakurt.weekend.character_list.R
import com.burhan.karakurt.weekend.character_list.databinding.FragmentCharacterListBinding
import com.burhan.karakurt.weekend.common.base.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : BaseFragment<FragmentCharacterListBinding>() {


    private val characterListViewModel: CharacterListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }


    override fun getLayoutId(): Int = R.layout.fragment_character_list

    fun setUpViewModel() {
        with(characterListViewModel) {
            getLayoutViewState().observe(viewLifecycleOwner) {
                binding.layoutViewState = it
                binding.executePendingBindings()
                //handle error layout
            }
            getCharacterListViewState().observe(viewLifecycleOwner) {
                binding.characterListViewState = it
                binding.executePendingBindings()
            }
        }
    }

}