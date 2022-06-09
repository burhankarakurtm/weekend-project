package com.burhan.karakurt.weekend.character_list.ui.adapter

import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel

interface ItemAdapterClickListener {
    fun onClickItem(characterModel: MarvelCharacterModel)
}