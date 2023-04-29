package com.bishal.narutoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.bishal.narutoapp.data.respository.Repository
import com.bishal.narutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}