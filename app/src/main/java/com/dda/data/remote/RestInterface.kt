package com.dda.data.remote

import com.dda.data.model.NewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface RestInterface {
    //NEWS LIST
    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json")
    suspend fun getNewsList(@Query("api-key") apikey: String): NewsList
}