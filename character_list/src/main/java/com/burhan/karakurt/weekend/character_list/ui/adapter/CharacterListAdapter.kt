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

    private var itemAdapterClickListener: ItemAdapterClickListener? = null

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["android:setCharacterList", "android:setItemAdapterClickListener"])
        fun setCharacterList(
            view: RecyclerView?,
            characterList: List<MarvelCharacterModel>?,
            itemAdapterClickListener: ItemAdapterClickListener?
        ) {
            view?.let {
                if (it.adapter == null) {
                    it.adapter = CharacterListAdapter()
                }
                (it.adapter as CharacterListAdapter).addClickListener(itemAdapterClickListener)
                (it.adapter as CharacterListAdapter).submitList(characterList)
                (it.adapter as CharacterListAdapter).notifyDataSetChanged()
            }
        }


        val DIFF_UTIL = object : DiffUtil.ItemCallback<MarvelCharacterModel>() {
            override fun areItemsTheSame(
                oldItem: MarvelCharacterModel,
                newItem: MarvelCharacterModel
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: MarvelCharacterModel,
                newItem: MarvelCharacterModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun addClickListener(itemAdapterClickListener: ItemAdapterClickListener?) {
        this.itemAdapterClickListener = itemAdapterClickListener
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bindData(getItem(position), itemAdapterClickListener)
    }
}