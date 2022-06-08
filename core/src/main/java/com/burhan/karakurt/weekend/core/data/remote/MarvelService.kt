package com.burhan.karakurt.weekend.core.data.remote

import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("/v1/public/characters")
    suspend fun getCharacterList(
        @Query("apikey") apiKey: String?,
        @Query("hash") hash: String?
    ): MarvelCharacterResponse

}