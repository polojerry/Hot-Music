package com.polotechnologies.hotmusic.dataModel

import com.squareup.moshi.Json

data class Track (
    @Json(name = "name") val track_name : String,
    val duration : String,
    @Json(name = "playcount") val play_count : String,
    val listeners : String,
    val mbid : String,
    val url : String,
    val streamable : Streamable,
    val artist : TrackArtist,
    val image : List<TrackImage>
)

data class TrackImage (
    @Json(name = "#text") val url: String,
    val size : String
)


data class TrackArtist(
    @Json(name = "name")val artist_name : String,
    val mbid: String,
    val url : String
)

data class Streamable (
    @Json(name = "#text") val text : String,
    val fulltrack : String
)
