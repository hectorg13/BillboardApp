package com.smartsolution.billboardapp.model.core

import com.google.gson.GsonBuilder
import com.smartsolution.billboardapp.model.Constants
import com.smartsolution.billboardapp.model.network.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(WebService::class.java)
    }
}