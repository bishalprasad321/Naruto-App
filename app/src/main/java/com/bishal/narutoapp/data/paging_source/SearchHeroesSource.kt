package com.bishal.narutoapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bishal.narutoapp.data.remote.NarutoApi
import com.bishal.narutoapp.domain.model.Hero
import javax.inject.Inject

class SearchHeroesSource @Inject constructor(
    private val narutoApi: NarutoApi,
    private val query: String
):PagingSource<Int, Hero>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = narutoApi.searchHeroes(name = query)
            val heroes = apiResponse.heroes
            if (heroes.isNotEmpty()){
                LoadResult.Page(
                    data = heroes,
                    nextKey = apiResponse.nextPage,
                    prevKey = apiResponse.prevPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }
}