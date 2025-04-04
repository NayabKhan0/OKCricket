package com.android.okcricket.di

import com.android.okcricket.network.ApiService
import com.android.okcricket.network.RetrofitHelper
import com.android.okcricket.repository.MatchRepository
import com.android.okcricket.viewmodel.MatchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single<ApiService> { RetrofitHelper.createRetrofit() }
}

val repositoryModule = module {
    single { MatchRepository(get()) }
}

val viewModelModule = module {
    viewModel { MatchViewModel(get()) }
}