package com.smartepay.news.data.network



import com.smartepay.news.data.model.NewsResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface ApiHelper {

    @GET("top-headlines?country=us&apiKey=a976cc6aa2434b299609d5c234a9d0a4")
    fun getNews()
            : Observable<NewsResponse>

}