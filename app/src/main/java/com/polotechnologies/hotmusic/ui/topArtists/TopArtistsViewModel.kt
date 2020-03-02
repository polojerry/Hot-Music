package com.polotechnologies.hotmusic.ui.topArtists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.hotmusic.network.ArtistsResponse
import com.polotechnologies.hotmusic.network.HotMusicApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopArtistsViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    init{
        getTopMusic()
    }

    private fun getTopMusic() {
        coroutineScope.launch {
            val getTopMusic = HotMusicApi.retrofitService.getTopArtist()
            try{
                val topMusic = getTopMusic.await().artists.artist
                _response.value = "Successfully fetched: ${topMusic.size}"
            }
            catch (t: Throwable){
                _response.value = "Failed due to: ${t.localizedMessage}"
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}