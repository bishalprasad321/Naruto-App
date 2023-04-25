package com.bishal.narutoapp.data.respository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bishal.narutoapp.data.local.NarutoDatabase
import com.bishal.narutoapp.data.paging_source.HeroRemoteMediator
import com.bishal.narutoapp.data.remote.NarutoApi
import com.bishal.narutoapp.domain.model.Hero
import com.bishal.narutoapp.domain.repository.RemoteDatasource
import com.bishal.narutoapp.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val narutoApi: NarutoApi,
    private val narutoDatabase: NarutoDatabase
): RemoteDatasource {

    private val heroDao = narutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                narutoApi = narutoApi,
                narutoDatabase = narutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }
}