package com.burhan.karakurt.weekend.character_list.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burhan.karakurt.weekend.character_list.databinding.ItemCharacterBinding
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel

class CharacterListViewHolder(private val binding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindData(characterModel: MarvelCharacterModel) {
        binding.characterModel = characterModel
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): CharacterListViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCharacterBinding.inflate(
                inflater,
                parent,
                false
            )
            return CharacterListViewHolder(binding)
        }
    }

}