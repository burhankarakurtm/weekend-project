package com.burhan.karakurt.weekend.core.data.repository

import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterResponse
import com.burhan.karakurt.weekend.core.data.remote.MarvelService
import javax.inject.Inject

class MarvelDataSource @Inject constructor(private val marvelService: MarvelService) {
    suspend fun fetchCharacterList(
        apiKey: String?,
        hash: String?
    ): MarvelCharacterResponse = marvelService.getCharacterList(apiKey, hash)
}