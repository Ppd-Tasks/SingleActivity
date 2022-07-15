package com.example.singleactivity.network

import com.example.singleactivity.model.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {

    @GET("photos/random?count=50")
    fun listPhotos(): Call<ArrayList<ResponseItem>>

    @GET("topics/nature/photos")
    fun listPhotosNature():Call<ArrayList<ResponseItem>>

    @GET("photos/random?count=60")
    fun listPhotosForYou():Call<ArrayList<ResponseItem>>

    @GET("topics/animals/photos")
    fun listPhotosAnimals():Call<ArrayList<ResponseItem>>
}