package com.polotechnologies.hotmusic.dataModel

import com.squareup.moshi.Json

data class Artist (
    @Json (name = "name")val artist_name : String,
    val play_count : String,
    val listeners : String,
    @Json(name = "mbid") val m_bid : String,
    val url : String,
    val streamable : String,
    @Json(name = "image")val images : List<ArtistImage>

)

data class ArtistImage (
    @Json(name = "#text") val image_url : String,
    @Json(name = "size") val image_size : String
)
