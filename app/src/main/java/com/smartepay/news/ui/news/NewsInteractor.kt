package com.smartepay.news.ui.news

import androidx.lifecycle.LiveData
import com.smartepay.news.data.db.NewsDataDao
import com.smartepay.news.data.db.NewsDataTB
import com.smartepay.news.data.model.NewsResponse
import com.smartepay.news.data.network.ApiHelper
import com.smartepay.news.ui.base.BaseInteractor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class NewsInteractor @Inject constructor(apiHelper: ApiHelper , newsDataDao: NewsDataDao) : BaseInteractor(apiHelper,newsDataDao) {

    fun getNewsFromApi(): Observable<NewsResponse> = apiHelper.getNews( )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())



    fun getNewsFromLocal(): List<NewsDataTB> = newsDataDao.getNewsArticles()


    fun insertLastNews(newsData: List<NewsDataTB>) = newsDataDao.clearAndCacheNews(newsData)



}