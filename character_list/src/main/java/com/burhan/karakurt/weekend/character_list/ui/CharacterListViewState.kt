package com.burhan.karakurt.weekend.character_list.ui

import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel

class CharacterListViewState(private val characterList: List<MarvelCharacterModel>) {

    fun getCharacterList() = characterList
}