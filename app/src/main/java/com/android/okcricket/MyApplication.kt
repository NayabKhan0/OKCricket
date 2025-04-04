package com.android.okcricket

import android.app.Application
import com.android.okcricket.di.networkModule
import com.android.okcricket.di.repositoryModule
import com.android.okcricket.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}