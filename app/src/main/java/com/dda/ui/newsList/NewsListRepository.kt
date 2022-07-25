package com.dda.ui.newsList;

import com.dda.data.remote.RestInterface
import javax.inject.Inject

class NewsListRepository @Inject constructor(
    val restInterface: RestInterface,
    val apiKey: String
) {
    suspend fun getNewsList() =
        restInterface.getNewsList(apiKey)

}
