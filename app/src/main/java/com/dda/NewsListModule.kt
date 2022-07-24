package com.dda

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext


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