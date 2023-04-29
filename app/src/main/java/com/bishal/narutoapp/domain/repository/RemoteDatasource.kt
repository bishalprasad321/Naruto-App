package com.bishal.narutoapp.domain.repository

import androidx.paging.PagingData
import com.bishal.narutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDatasource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}