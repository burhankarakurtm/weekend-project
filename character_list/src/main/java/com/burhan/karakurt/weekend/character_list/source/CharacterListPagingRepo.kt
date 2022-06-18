package com.burhan.karakurt.weekend.character_list.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel
import com.burhan.karakurt.weekend.core.data.repository.MarvelDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterListPagingRepo @Inject constructor(private val marvelDataSource: MarvelDataSource) {

    fun letCharacterListFlow(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<MarvelCharacterModel>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { CharacterListPagingDataSource(marvelDataSource) }
        ).flow
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = 20, enablePlaceholders = true)
    }
}