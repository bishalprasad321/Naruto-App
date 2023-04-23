package com.bishal.narutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bishal.narutoapp.data.local.dao.HeroDao
import com.bishal.narutoapp.data.local.dao.HeroRemoteKeysDao
import com.bishal.narutoapp.domain.model.Hero
import com.bishal.narutoapp.domain.model.HeroRemoteKeys


@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class NarutoDatabase : RoomDatabase(){

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}