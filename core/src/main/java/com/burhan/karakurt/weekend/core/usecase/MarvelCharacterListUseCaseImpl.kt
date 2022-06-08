package com.burhan.karakurt.weekend.core.usecase

import com.burhan.karakurt.weekend.common.base.data.State
import com.burhan.karakurt.weekend.common.extensions.map
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel
import com.burhan.karakurt.weekend.core.data.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MarvelCharacterListUseCaseImpl @Inject constructor(private val marvelRepository: MarvelRepository) :
    MarvelCharacterListUseCase {
    override fun getCharacterList(
        apiKey: String?,
        hash: String?
    ): Flow<State<List<MarvelCharacterModel>>> =
        marvelRepository.fetchCharacterList(apiKey, hash).map { state ->
            state.map { response ->
                response.data.results
            }
        }
}