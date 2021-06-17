package com.smartepay.news.data.model

import androidx.databinding.ObservableField


data class NewsItemViewModel(var imageNews: ObservableField<String>,
                             var author: ObservableField<String>,
                                 var title: ObservableField<String>,
                                 var url: ObservableField<String>,
                                 var publishedAt: ObservableField<String>,
                                 var description: ObservableField<String>)