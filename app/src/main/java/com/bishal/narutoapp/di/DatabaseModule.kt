package com.bishal.narutoapp.di

import android.content.Context
import androidx.room.Room
import com.bishal.narutoapp.data.local.NarutoDatabase
import com.bishal.narutoapp.util.Constants.NARUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NarutoDatabase {
        return Room.databaseBuilder(
            context,
            NarutoDatabase::class.java,
            NARUTO_DATABASE
        ).build()
    }
}