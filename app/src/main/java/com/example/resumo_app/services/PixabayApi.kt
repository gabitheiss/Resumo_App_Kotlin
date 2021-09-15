package com.example.resumo_app.services

import com.example.resumo_app.BuildConfig
import com.example.resumo_app.model.PixabayImages
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PixabayApi {

    @GET("/api/")
    suspend fun getImages(@Query("key") key : String = BuildConfig.API_KEY,
                            @Query("q") q : String,
                            @Query("lang") lang : String = "pt",
                            @Query("page") page: Int = 1) : Response<PixabayImages>
}