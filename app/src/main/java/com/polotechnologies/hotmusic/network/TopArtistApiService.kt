package com.polotechnologies.hotmusic.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val API_KEY = "fe4256a1374cab3e71b4d9d9dc6e39c5"
private const val BASE_URL_TOP_ARTISTS = "http://ws.audioscrobbler.com/2.0/"

//Retrofit Object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL_TOP_ARTISTS)
    .build()

//API Service Interface
interface TopArtistApiService {
    @GET("?method=chart.gettopartists&api_key=$API_KEY&format=json")
    fun getTopArtist(): Call<String>
}

//TopArtist API object Implementation of the service
object TopArtistApi{
    val retrofitService : TopArtistApiService by lazy {
        retrofit.create(TopArtistApiService::class.java)
    }

}