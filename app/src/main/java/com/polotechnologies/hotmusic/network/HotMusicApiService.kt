package com.polotechnologies.hotmusic.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val API_KEY = "fe4256a1374cab3e71b4d9d9dc6e39c5"
private const val BASE_URL_TOP_ARTISTS = "http://ws.audioscrobbler.com/2.0/"

//Moshi Converter with Kotshi
/*private val moshi = Moshi.Builder()
    .add(ApplicationJsonAdapterFactory)
    .build()*/

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Retrofit Object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL_TOP_ARTISTS)
    .build()

//API Service Interface
interface HotMusicApiService {

    @GET("?method=chart.gettopartists&api_key=$API_KEY&format=json")
    fun getTopArtist():
            Deferred<ArtistsResponse>
}

//TopArtist API object Implementation of the service
object HotMusicApi{
    val retrofitService : HotMusicApiService by lazy {
        retrofit.create(HotMusicApiService::class.java)
    }

}