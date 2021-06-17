package com.smartepay.news.data.db


import androidx.room.Database

import androidx.room.RoomDatabase

@Database(
        entities = [NewsDataTB::class],
        version = 2
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDataDao(): NewsDataDao

}