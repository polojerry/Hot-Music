package com.polotechnologies.hotmusic.network.responseDataModels

import com.polotechnologies.hotmusic.dataModel.Track

data class TracksResponse(
    val tracks: TrackResponse
)

data class TrackResponse(
    val track: List<Track>
)
