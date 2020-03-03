package com.polotechnologies.hotmusic.ui.topTracks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotechnologies.hotmusic.dataModel.Track
import com.polotechnologies.hotmusic.network.HotMusicApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TopTracksViewModel : ViewModel() {

    private val _topTracksStatus = MutableLiveData<String>()
    val topTracksStatus: LiveData<String>
        get() = _topTracksStatus

    private val _topTracks = MutableLiveData<List<Track>>()
    val topTracks: LiveData<List<Track>>
        get() = _topTracks

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getTopTracks()
    }

    private fun getTopTracks() {
        coroutineScope.launch {
            val topTracksDeferred = HotMusicApi.retrofitService.getTopTracks()
            try {
                val topTracks = topTracksDeferred.await().tracks
                _topTracks.value = topTracks.track
            }catch (t: Throwable){
                _topTracksStatus.value = "Failed due to: ${t.localizedMessage}"
            }
        }
    }
}