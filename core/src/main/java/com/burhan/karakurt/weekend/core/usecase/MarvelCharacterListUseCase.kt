package com.burhan.karakurt.weekend.core.usecase

import com.burhan.karakurt.weekend.common.base.data.State
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel
import kotlinx.coroutines.flow.Flow

interface MarvelCharacterListUseCase {
    fun getCharacterList(
        apiKey: String?,
        hash: String?,
        timeStamp: String,
        limit: Int,
        offset: Int
    ): Flow<State<List<MarvelCharacterModel>>>
}