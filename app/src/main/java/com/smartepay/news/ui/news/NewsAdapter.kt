package com.smartepay.news.ui.news


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.smartepay.news.R
import com.smartepay.news.data.model.NewsItemViewModel
import com.smartepay.news.databinding.ItemNewsBinding


class NewsAdapter(var newsViewModel: NewsViewModel, var newData: ArrayList<NewsItemViewModel>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:ItemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }




    fun insertAll(mData: List<NewsItemViewModel>) {
        with(newData) {
            this?.clear()
            this?.addAll(mData)
            notifyDataSetChanged()
        }
    }



    inner class ViewHolder(var view: ItemNewsBinding) : RecyclerView.ViewHolder(view.root) {
         fun onBind(position: Int) {
            // initialize viewModel and the clickListener Implementation
            val newsItemViewModel = newData?.get(position)
            view.model = newsItemViewModel
            view.itemClickListener = newsViewModel
            view.executePendingBindings()

        }
    }

    override fun getItemCount(): Int {
         return newData!!.size
    }
}