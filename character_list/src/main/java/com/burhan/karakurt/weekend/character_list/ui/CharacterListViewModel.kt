package com.burhan.karakurt.weekend.character_list.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.burhan.karakurt.weekend.common.base.ui.LayoutViewState
import com.burhan.karakurt.weekend.common.extensions.doOnSuccess
import com.burhan.karakurt.weekend.core.usecase.MarvelCharacterListUseCase
import com.burhan.karakurt.weekend.core.util.ApiUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val marvelCharacterListUseCase: MarvelCharacterListUseCase) :
    ViewModel() {

    private val layoutViewStateLiveData = MutableLiveData<LayoutViewState>()
    private val characterListViewStateLiveData = MutableLiveData<CharacterListViewState>()

    fun getCharacterListViewState() = characterListViewStateLiveData
    fun getLayoutViewState() = layoutViewStateLiveData


    init {
        getCharacterList(1)
    }

    private fun getCharacterList(offset: Int) {
        marvelCharacterListUseCase
            .getCharacterList(
                ApiUtil.PUBLIC_API_KEY,
                ApiUtil.getMd5Key(),
                ApiUtil.TIME_STAMP,
                30,
                offset
            )
            .doOnSuccess { characterListViewStateLiveData.value = CharacterListViewState(it) }
            .onEach { state -> layoutViewStateLiveData.value = LayoutViewState(state) }
            .launchIn(viewModelScope)
    }
}