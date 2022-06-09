package com.burhan.karakurt.weekend.core.data.repository

import com.burhan.karakurt.weekend.common.base.data.BaseRepository
import com.burhan.karakurt.weekend.common.base.data.State
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(private val marvelDataSource: MarvelDataSource) :
    MarvelRepository, BaseRepository() {
    override fun fetchCharacterList(
        apiKey: String?,
        hash: String?,
        timeStamp: String,
        limit: Int,
        offset: Int
    ): Flow<State<MarvelCharacterResponse>> = apiCall {
        marvelDataSource.fetchCharacterList(apiKey, hash,timeStamp, limit, offset)
    }
}