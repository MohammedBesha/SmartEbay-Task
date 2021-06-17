package com.smartepay.news.di

import android.content.Context
import androidx.room.Room
import com.smartepay.news.data.db.NewsDataDao
import com.smartepay.news.data.db.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataBaseModule {



    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, "news_DB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    @Provides
    @Singleton
    fun provideDao(newsDataDB: NewsDatabase): NewsDataDao {
        return newsDataDB.newsDataDao()
    }

}