package com.burhan.karakurt.weekend.character_list.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.burhan.karakurt.weekend.core.data.model.MarvelCharacterModel
import com.burhan.karakurt.weekend.core.data.repository.MarvelDataSource
import com.burhan.karakurt.weekend.core.util.ApiUtil
import java.io.IOException

class CharacterListPagingDataSource(private val dataSource: MarvelDataSource) :
    PagingSource<Int, MarvelCharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, MarvelCharacterModel>): Int = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarvelCharacterModel> {
        val page = params.key ?: 1
        return try {
            val response = dataSource.fetchCharacterList(
                ApiUtil.PUBLIC_API_KEY,
                ApiUtil.getMd5Key(),
                ApiUtil.TIME_STAMP,
                params.loadSize, page
            ).data
            LoadResult.Page(
                response.results, prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}