package com.k1ch.aqb.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://animechan.vercel.app/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface QuoteBookApiService{
    @GET("quotes")
    suspend fun getQuote(): List<AnimeQuote>
}

object QuoteBookApi {
    val retrofitService : QuoteBookApiService by lazy {
        retrofit.create(QuoteBookApiService::class.java) }
}