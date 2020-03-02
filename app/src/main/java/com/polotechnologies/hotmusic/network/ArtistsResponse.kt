package com.polotechnologies.hotmusic.network

import com.polotechnologies.hotmusic.dataModel.Artist

data class ArtistsResponse(
    val artists : ArtistResponse
)

data class ArtistResponse(
    val artist : List<Artist>
)
