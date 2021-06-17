package com.smartepay.news.data.db


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction



@Dao
interface NewsDataDao {

    @Insert
    fun insertArticles(articles: List<NewsDataTB>): List<Long>

    @Query("DELETE FROM news_data")
    fun clearAllArticles()

    @Transaction
    fun clearAndCacheNews(articles: List<NewsDataTB>) {
        clearAllArticles()
        insertArticles(articles)
    }


    @Query("SELECT * FROM news_data")
    fun getNewsArticles(): List<NewsDataTB>
}