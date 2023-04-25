package com.bishal.narutoapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.bishal.narutoapp.data.respository.Repository
import com.bishal.narutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}