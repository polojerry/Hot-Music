package com.polotechnologies.hotmusic.ui.topArtists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.hotmusic.dataModel.Artist
import com.polotechnologies.hotmusic.network.HotMusicApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TopArtistsViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val _topArtists = MutableLiveData<List<Artist>>()
    val topArtist: LiveData<List<Artist>>
        get() = _topArtists

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getTopArtists()
    }

    private fun getTopArtists() {
        coroutineScope.launch {
            val getTopArtists = HotMusicApi.retrofitService.getTopArtist()
            try {
                val topArtists = getTopArtists.await().artists.artist
                _topArtists.value = topArtists
            } catch (t: Throwable) {
                _response.value = "Failed due to: ${t.localizedMessage}"
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}