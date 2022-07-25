package com.dda.module

import com.dda.BuildConfig
import com.dda.ui.newsList.NewsListRepository
import com.dda.data.remote.NetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class NewsListModule {
    @Provides
    fun provideRestInterface() = NetworkApi.getRestClient()

    @Provides
    fun provideRepository() = NewsListRepository(
        provideRestInterface(),
        BuildConfig.NYTIMES_API_KEY
    )
}