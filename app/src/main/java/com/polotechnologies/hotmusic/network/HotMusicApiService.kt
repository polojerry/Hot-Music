package com.polotechnologies.hotmusic.network

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val API_KEY = "fe4256a1374cab3e71b4d9d9dc6e39c5"
private const val BASE_URL_TOP_ARTISTS = "http://ws.audioscrobbler.com/2.0/"

//Moshi Converter with Kotshi
private val moshi = Moshi.Builder()
    .add(ApplicationJsonAdapterFactory)
    .build()

//Retrofit Object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_TOP_ARTISTS)
    .build()

//API Service Interface
interface HotMusicApiService {

    @GET("?method=chart.gettopartists&api_key=$API_KEY&format=json")
    fun getTopArtist(): Call<ArtistsResponse>
}

//TopArtist API object Implementation of the service
object HotMusicApi{
    val retrofitService : HotMusicApiService by lazy {
        retrofit.create(HotMusicApiService::class.java)
    }

}