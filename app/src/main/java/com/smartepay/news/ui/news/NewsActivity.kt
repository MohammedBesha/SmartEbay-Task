package com.smartepay.news.ui.news


import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartepay.news.R
import com.smartepay.news.data.model.NewsDetailsPar
import com.smartepay.news.data.model.NewsItemViewModel
import com.smartepay.news.databinding.ActivityNewsBinding
import com.smartepay.news.ui.base.BaseActivity
import com.smartepay.news.ui.newsdetails.NewsDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : BaseActivity() {


    @Inject
    lateinit var newsVieModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var newsViewModel: NewsViewModel



    private var newsList: ArrayList<NewsItemViewModel> = ArrayList()


    private lateinit var mViewBinding: ActivityNewsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setupView() {


        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)

        setupActionBar()

        // initialize recyclerView
        val rvNewsLines = mViewBinding.rvNews
        rvNewsLines.layoutManager = LinearLayoutManager(this)
        val newsAdapter = NewsAdapter(newsViewModel, newsList)
        rvNewsLines.adapter = newsAdapter
        // call data from server

        mViewBinding.newsViewModel = newsViewModel
        mViewBinding.executePendingBindings()

        getNewsData()
        // observe when data change
        newsViewModel.newsItemLiveData.observe(this@NewsActivity as LifecycleOwner, Observer {
            newsAdapter.insertAll(it)
        })
        // observe when item clicked
        newsViewModel.newsItemViewModelData.observe(this@NewsActivity as LifecycleOwner, Observer {
            startNewsDetailsActivity(it)
        })
    }


    private fun setupActionBar() {
        val actionBar = supportActionBar
        if (actionBar != null) {
            //setup back button
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar.setCustomView(R.layout.custom_title)

        }
    }

    private fun startNewsDetailsActivity(newsData: NewsDetailsPar) {
        startActivity(NewsDetailsActivity.callingIntent( this,newsData))
    }


    private fun getNewsData() {

        newsViewModel.getNewsData(this)


    }
}