package com.burhan.karakurt.weekend.character_list.ui.adapter

import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel

class CharacterListAdapter :
    PagingDataAdapter<MarvelCharacterModel, CharacterListViewHolder>(DIFF_UTIL) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder.create(parent)
    }

    private var itemAdapterClickListener: ItemAdapterClickListener? = null

    companion object {
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
                return oldItem.name == newItem.name
            }
        }
    }

    fun addClickListener(itemAdapterClickListener: ItemAdapterClickListener?) {
        this.itemAdapterClickListener = itemAdapterClickListener
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        getItem(position)?.let { holder.bindData(it, itemAdapterClickListener) }
    }
}