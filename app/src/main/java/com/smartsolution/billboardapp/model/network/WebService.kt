package com.smartsolution.billboardapp.model.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("now_playing")
    suspend fun getBillboard(
        @Query("api_key") apiKey: String
    ): Response<MoviesResponse>

    @GET("popular")
    suspend fun getPopulars(
        @Query("api_key") apiKey: String
    ): Response<MoviesResponse>

    @GET("top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey: String
    ): Response<MoviesResponse>
}