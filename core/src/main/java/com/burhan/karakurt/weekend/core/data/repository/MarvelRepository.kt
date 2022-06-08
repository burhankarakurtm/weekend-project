package com.burhan.karakurt.weekend.core.data.repository

import com.burhan.karakurt.weekend.common.base.data.State
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterResponse
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    suspend fun fetchCharacterList(
        apiKey: String?,
        hash: String?
    ): Flow<State<MarvelCharacterResponse>>
}