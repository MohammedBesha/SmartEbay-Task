package com.smartepay.news.ui.newsdetails


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.smartepay.news.R
import com.smartepay.news.data.model.NewsDetailsPar
import com.smartepay.news.databinding.NewsDetalisBinding
import com.smartepay.news.ui.base.BaseActivity

class NewsDetailsActivity : BaseActivity() {


     private lateinit var mViewBinding: NewsDetalisBinding

    private lateinit var newsDetails: NewsDetailsPar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setupView() {


        mViewBinding = DataBindingUtil.setContentView(this, R.layout.news_detalis)

        setupActionBar()

        val bundle = intent.getBundleExtra(INTENT_EXTRA_PARAM_BUNDLE)
        if (bundle != null) {
            newsDetails = bundle.getParcelable<NewsDetailsPar>(INTENT_EXTRA_PARAM_NEWS)!!
            Log.e("NewDeatils", newsDetails.author!!)
            mViewBinding.model = newsDetails
        }


    }

    fun setupActionBar() {
        val actionBar = supportActionBar
        if (actionBar != null) {
            //setup back button
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

        companion object {
            private const val INTENT_EXTRA_PARAM_BUNDLE= "Bundle"
            private const val INTENT_EXTRA_PARAM_NEWS = "NewsDetails"

            fun callingIntent(context: Context, newsDetails: NewsDetailsPar):Intent {
                val intent = Intent(context, NewsDetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable(INTENT_EXTRA_PARAM_NEWS, newsDetails)
                intent.putExtra(INTENT_EXTRA_PARAM_BUNDLE, bundle)
               return intent
            }

        }
}
