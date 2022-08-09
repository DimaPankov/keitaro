package com.example2.testProject.model

import com.example2.testProject.model.models.JsonData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://tracker.infinitum.works/"

val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ApiService {
    @GET("click_api/v3")
    suspend fun getData(
        @Query("token") token: String = "mtzbj4kjdtszjx1nvv7mnrtw4qt1w7gb",
        @Query("log") log: String = "1",
        @Query("info") info: String = "1",
    ): JsonData
}

object RetrofitApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}