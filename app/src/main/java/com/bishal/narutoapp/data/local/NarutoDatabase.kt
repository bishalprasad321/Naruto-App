package com.bishal.narutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bishal.narutoapp.data.local.dao.HeroDao
import com.bishal.narutoapp.data.local.dao.HeroRemoteKeyDao
import com.bishal.narutoapp.domain.model.Hero
import com.bishal.narutoapp.domain.model.HeroRemoteKey


@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class NarutoDatabase : RoomDatabase(){

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}