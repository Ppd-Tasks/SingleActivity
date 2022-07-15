package com.example.singleactivity.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHttp {

    val SERVER_DEVELOPMENT = "https://api.unsplash.com/"

    private val client = getClient()
    private val retrofit = getRetrofit(client)

    fun getRetrofit(client: OkHttpClient): Retrofit {
        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SERVER_DEVELOPMENT)
            .client(client)
            .build()
        return build
    }

    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }

    fun getClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.header("Authorization", "Client-ID r_PBgcCBLgDICSpQXjRHOPe7e0N0kK4frHbnE60dryE")
            chain.proceed(builder.build())
        })
        .build()

    fun <T> createServiceWithAuth(service: Class<T>?): T {

        val newClient =
            client.newBuilder().addInterceptor(Interceptor { chain ->
                var request = chain.request()
                val builder = request.newBuilder()
                builder.addHeader(
                    "Authorization",
                    "Client-ID r_PBgcCBLgDICSpQXjRHOPe7e0N0kK4frHbnE60dryE"
                )
                request = builder.build()
                chain.proceed(request)
            }).build()
        val newRetrofit = retrofit.newBuilder().client(newClient).build()
        return newRetrofit.create(service!!)
    }

    val posterService: HomeService = retrofit.create(HomeService::class.java)


}