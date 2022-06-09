package com.burhan.karakurt.weekend.character_list.ui.adapter

import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel

class CharacterListAdapter : ListAdapter<MarvelCharacterModel, CharacterListViewHolder>(DIFF_UTIL) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder.create(parent)
    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["android:setCharacterList"])
        fun setCharacterList(
            view: RecyclerView?,
            characterList: List<MarvelCharacterModel>?,
        ) {
            view?.let {
                if (it.adapter == null) {
                    it.adapter = CharacterListAdapter()
                }
                (it.adapter as CharacterListAdapter).submitList(characterList)
                (it.adapter as CharacterListAdapter).notifyDataSetChanged()
            }
        }


        val DIFF_UTIL = object : DiffUtil.ItemCallback<MarvelCharacterModel>() {
            override fun areItemsTheSame(
                oldItem: MarvelCharacterModel,
                newItem: MarvelCharacterModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MarvelCharacterModel,
                newItem: MarvelCharacterModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}