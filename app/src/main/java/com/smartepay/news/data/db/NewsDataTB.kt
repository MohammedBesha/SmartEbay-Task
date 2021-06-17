package com.smartepay.news.data.db

import androidx.room.ColumnInfo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.smartepay.news.data.db.NewsDataTB.NewsArticles.tableName


@Entity(tableName = tableName)
data class NewsDataTB(

    /**
     * Primary key for Room.
     */
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    // Name of the author for the article
    @ColumnInfo(name = NewsArticles.Column.author)
    val author: String? = null,

    // Title of the article

    @ColumnInfo(name = NewsArticles.Column.title)
    val title: String? = null,

    //Complete description of the article

    @ColumnInfo(name = NewsArticles.Column.description)
    val description: String? = null,


   // URL to the article
    @ColumnInfo(name = NewsArticles.Column.url)
    val url: String? = null,

  //URL of the artwork shown with article
    @ColumnInfo(name = NewsArticles.Column.urlToImage)
    val urlToImage: String? = null,

   // Date-time when the article was published
    @ColumnInfo(name = NewsArticles.Column.publishedAt)
    val publishedAt: String? = null,

    ) {


    object NewsArticles {
        const val tableName = "news_data"
        object Column {
            const val id = "id"
            const val author = "author"
            const val title = "title"
            const val description = "description"
            const val url = "url"
            const val urlToImage = "urlToImage"
            const val publishedAt = "publishedAt"
        }
    }
}