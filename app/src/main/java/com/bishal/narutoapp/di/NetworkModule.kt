package com.bishal.narutoapp.di

import androidx.paging.ExperimentalPagingApi
import com.bishal.narutoapp.data.local.NarutoDatabase
import com.bishal.narutoapp.data.remote.NarutoApi
import com.bishal.narutoapp.data.respository.RemoteDataSourceImpl
import com.bishal.narutoapp.domain.repository.RemoteDatasource
import com.bishal.narutoapp.util.Constants.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@ExperimentalPagingApi
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideNarutoApi(retrofit: Retrofit): NarutoApi {
        return retrofit.create(NarutoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(
        narutoApi: NarutoApi,
        narutoDatabase: NarutoDatabase
    ): RemoteDatasource {
        return RemoteDataSourceImpl(
            narutoApi = narutoApi,
            narutoDatabase = narutoDatabase
        )
    }
}