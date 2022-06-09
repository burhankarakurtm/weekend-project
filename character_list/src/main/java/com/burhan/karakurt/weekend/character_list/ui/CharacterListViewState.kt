package com.burhan.karakurt.weekend.character_list.ui

import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel

class CharacterListViewState(private val characterList: ArrayList<MarvelCharacterModel>) {

    fun getCharacterList() = characterList

    fun addCharacterList(list: List<MarvelCharacterModel>){
        characterList.addAll(list)
    }
}