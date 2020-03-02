package com.polotechnologies.hotmusic.ui.topArtists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.hotmusic.network.ArtistsResponse
import com.polotechnologies.hotmusic.network.HotMusicApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopArtistsViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init{
        getTopMusic()
    }

    private fun getTopMusic() {
        HotMusicApi.retrofitService.getTopArtist().enqueue(object : Callback<ArtistsResponse> {
            override fun onFailure(call: Call<ArtistsResponse>, t: Throwable) {
                _response.value = "Failed due to: ${t.localizedMessage}"
            }

            override fun onResponse(call: Call<ArtistsResponse>, response: Response<ArtistsResponse>) {
                _response.value = "Successfully fetched: ${response.body()?.artists?.artist?.size}"
            }

        })
    }

}