package com.smartepay.news

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyNewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

    }
}