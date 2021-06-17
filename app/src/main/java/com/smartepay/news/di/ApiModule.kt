package com.smartepay.news.di

import com.smartepay.news.data.network.ApiHelper
import com.smartepay.news.data.network.RetroConnect
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideApi(): ApiHelper {
        return RetroConnect.initRetrofit()!!
    }


}