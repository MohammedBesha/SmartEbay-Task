package com.smartepay.news.ui.base

import com.smartepay.news.data.db.NewsDataDao
import com.smartepay.news.data.network.ApiHelper


open class BaseInteractor constructor(var apiHelper: ApiHelper ,var newsDataDao: NewsDataDao) : BaseInteractorInterface {



}