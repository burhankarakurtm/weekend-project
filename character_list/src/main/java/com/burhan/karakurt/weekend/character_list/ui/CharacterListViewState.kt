package com.burhan.karakurt.weekend.character_list.ui

import androidx.paging.PagingData
import com.burhan.karakurt.weekend.character_list.ui.adapter.ItemAdapterClickListener
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel

class CharacterListViewState(
    private val characterList: ArrayList<MarvelCharacterModel>? = null,
    private val pagingData: PagingData<MarvelCharacterModel>
) {

    fun getCharacterList() = characterList
    fun getPagingData() = pagingData

    fun addCharacterList(list: List<MarvelCharacterModel>) {
        characterList?.addAll(list)
    }

    var itemAdapterClickListener: ItemAdapterClickListener? = null
}