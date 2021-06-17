package com.smartepay.news.ui.base

import android.view.View

interface OnListItemClickListener {
    fun onItemClicked(view: View, position: Int)
    fun onItemClicked(view: View, itemViewModel: Any)
    fun onItemClicked(itemViewModel: Any)
}