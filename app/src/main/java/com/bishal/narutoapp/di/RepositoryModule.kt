package com.bishal.narutoapp.di

import android.content.Context
import com.bishal.narutoapp.data.respository.DataStoreOperationsImpl
import com.bishal.narutoapp.data.respository.Repository
import com.bishal.narutoapp.domain.repository.DataStoreOperations
import com.bishal.narutoapp.domain.use_cases.UseCases
import com.bishal.narutoapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.bishal.narutoapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.bishal.narutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.bishal.narutoapp.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository)
        )
    }
}