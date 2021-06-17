package com.smartepay.news.ui.news

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.smartepay.news.data.db.NewsDataTB
import com.smartepay.news.data.model.NewsDetailsPar
import com.smartepay.news.data.model.NewsItemViewModel
import com.smartepay.news.data.model.NewsResponse
import com.smartepay.news.ui.base.BaseViewModel
import com.smartepay.news.ui.base.OnListItemClickListener
import com.smartepay.news.utils.NetworkUtil

class NewsViewModel constructor(val interactor: NewsInteractor) : BaseViewModel(),
    OnListItemClickListener {


    private var newsVieModelList: ArrayList<NewsItemViewModel> = ArrayList()
    var newsItemLiveData: MutableLiveData<ArrayList<NewsItemViewModel>> = MutableLiveData()
    var newsItemViewModelData: MutableLiveData<NewsDetailsPar> = MutableLiveData()


    // call data from server
    private fun getNewsDataFromApi() {
        getCompositeDisposable().add(
            interactor.getNewsFromApi()
                .subscribe({ response ->
                    newsItemLiveData.value = getNewsItemViewModel(response.articles)
                    interactor.insertLastNews(getLatestTenNews(response.articles))

                }, { error -> Log.e("xxx", error.message.toString()) })
        )
    }



    // call data from server
    fun getNewsData(context:Context) {

        if (NetworkUtil.isNetworkConnected(context))
        {
            getNewsDataFromApi();

        }else{
            newsItemLiveData.value = getNewsLocalViewModel(interactor.getNewsFromLocal())
        }
    }

    // add data to itemViewModel
    private fun getNewsItemViewModel(articles: List<NewsResponse.Article?>?): ArrayList<NewsItemViewModel>? {
        articles?.map {
            val author: ObservableField<String> = ObservableField()
            val title: ObservableField<String> = ObservableField()
            val description: ObservableField<String> = ObservableField()
            val url: ObservableField<String> = ObservableField()
            val imageUrl: ObservableField<String> = ObservableField()
            val publishedAt: ObservableField<String> = ObservableField()

            author.set(it?.author)
            title.set(it?.title)
            description.set(it?.description)
            url.set(it?.url)
            imageUrl.set(it?.urlToImage)
            publishedAt.set(it?.publishedAt)
            newsVieModelList.add(
                NewsItemViewModel(
                    imageUrl,
                    author,
                    title,
                    url,
                    publishedAt,
                    description
                )
            )

        }
        return newsVieModelList
    }


    // add data to itemViewModel
    private fun getNewsLocalViewModel(articlesLocal: List<NewsDataTB>?): ArrayList<NewsItemViewModel>? {
        articlesLocal?.map {
            val author: ObservableField<String> = ObservableField()
            val title: ObservableField<String> = ObservableField()
            val description: ObservableField<String> = ObservableField()
            val url: ObservableField<String> = ObservableField()
            val imageUrl: ObservableField<String> = ObservableField()
            val publishedAt: ObservableField<String> = ObservableField()

            author.set(it?.author)
            title.set(it?.title)
            description.set(it?.description)
            url.set(it?.url)
            imageUrl.set(it?.urlToImage)
            publishedAt.set(it?.publishedAt)
            newsVieModelList.add(
                NewsItemViewModel(
                    imageUrl,
                    author,
                    title,
                    url,
                    publishedAt,
                    description
                )
            )

        }
        return newsVieModelList
    }




    // add data to itemViewModel
    private fun getLatestTenNews(articles: List<NewsResponse.Article?>?): List<NewsDataTB>{

        val lastNewsList: ArrayList<NewsDataTB> = ArrayList<NewsDataTB>()
        val totalNews: Int = articles!!.size
        articles!!.subList(Math.max(totalNews - 10, 0), totalNews).map {

            lastNewsList.add(
                NewsDataTB(
                    it.hashCode(),
                    it?.author,
                    it?.title,
                    it?.description,
                    it?.url,
                    it?.urlToImage,
                    it?.publishedAt
                )
            )
        }


        return lastNewsList

    }


    override fun onItemClicked(view: View, position: Int) {
        TODO("Not yet implemented")
    }


    override fun onItemClicked(view: View, itemViewModel: Any) {
        val news = itemViewModel as NewsItemViewModel


        newsItemViewModelData.value = NewsDetailsPar(
            news.author.get(), news.title.get(), news.description.get(), news.url.get(),
            news.imageNews.get(), news.publishedAt.get()
        )
    }

    override fun onItemClicked(itemViewModel: Any) {
        TODO("Not yet implemented")
    }


}