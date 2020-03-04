package com.polotechnologies.hotmusic.network.responseDataModels

import com.polotechnologies.hotmusic.dataModel.Artist

data class ArtistsResponse(
    val artists : ArtistResponse
)

data class ArtistResponse(
    val artist : List<Artist>
)
