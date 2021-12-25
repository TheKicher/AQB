package com.k1ch.aqb.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://animechan.vercel.app/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface QuoteBookApiService{
    @GET("random")
    suspend fun getQuote():String
}

object QuoteBookApi {
    val retrofitService : QuoteBookApiService by lazy {
        retrofit.create(QuoteBookApiService::class.java) }
}