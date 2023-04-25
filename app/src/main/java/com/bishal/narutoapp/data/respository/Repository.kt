package com.bishal.narutoapp.data.respository

import androidx.paging.PagingData
import com.bishal.narutoapp.domain.model.Hero
import com.bishal.narutoapp.domain.repository.DataStoreOperations
import com.bishal.narutoapp.domain.repository.RemoteDatasource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDatasource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>>{
        return remote.getAllHeroes()
    }
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}