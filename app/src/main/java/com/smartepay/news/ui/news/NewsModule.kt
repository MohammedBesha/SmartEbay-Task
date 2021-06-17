package com.smartepay.news.ui.news


import androidx.lifecycle.ViewModelProvider
import com.smartepay.news.data.db.NewsDataDao
import com.smartepay.news.data.network.ApiHelper
import com.smartepay.news.utils.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped


@Module
@InstallIn(ActivityComponent::class)
object NewsModule {




    @ActivityScoped
    @Provides
     fun provideNewsInteractor(apiHelper: ApiHelper,newsDao: NewsDataDao)
            : NewsInteractor {
        return NewsInteractor(apiHelper,newsDao)
    }

    @ActivityScoped
    @Provides
     fun provideNewsViewModer(interactor: NewsInteractor): NewsViewModel {
        return NewsViewModel(interactor)
    }

    @ActivityScoped
    @Provides
     fun provideNewsViewModeFactory(newsViewModel: NewsViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(newsViewModel)
    }
}