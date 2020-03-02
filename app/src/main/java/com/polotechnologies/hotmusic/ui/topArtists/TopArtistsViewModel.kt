package com.polotechnologies.hotmusic.ui.topArtists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.hotmusic.network.TopArtistApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopArtistsViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init{
        getTopHeroes()
    }

    private fun getTopHeroes() {
        TopArtistApi.retrofitService.getTopArtist().enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failed due to: ${t.localizedMessage}"
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

        })
    }

}