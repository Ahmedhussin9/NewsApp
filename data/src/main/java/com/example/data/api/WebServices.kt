package com.example.data.api


import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey")
        apiKey:String = Constants.apiKey
    ): com.example.domain.model.SourcesResponse

}