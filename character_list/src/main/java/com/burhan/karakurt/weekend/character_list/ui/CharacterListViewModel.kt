package com.burhan.karakurt.weekend.character_list.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.burhan.karakurt.weekend.common.base.ui.LayoutViewState
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel
import com.burhan.karakurt.weekend.character_list.source.CharacterListPagingRepo
import com.burhan.karakurt.weekend.common.base.data.State
import com.burhan.karakurt.weekend.core.usecase.MarvelCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterListPagingRepo: CharacterListPagingRepo
) : ViewModel() {

    private val layoutViewStateLiveData = MutableLiveData<LayoutViewState>()

    fun getLayoutViewState() = layoutViewStateLiveData


    fun fetchCharacterListFlow(): Flow<PagingData<MarvelCharacterModel>> {
        return characterListPagingRepo.letCharacterListFlow()
            .map {
                it
            }.cachedIn(viewModelScope)
    }
}