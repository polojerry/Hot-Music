package com.polotechnologies.hotmusic.dataModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.polotechnologies.hotmusic.database.typeConverters.ArtistImageConverter
import com.polotechnologies.hotmusic.database.typeConverters.ArtistImageConverterList
import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@Entity(tableName = "top_artists_table")
@JsonSerializable
data class Artist (
    @PrimaryKey
    @Json (name = "name")val artist_name : String,

    @Json( name = "playcount") val play_count : String,

    val listeners : String,

    @Json(name = "mbid") val m_bid : String,

    val url : String,

    val streamable : String,

    @TypeConverters(ArtistImageConverterList::class)
    @Json(name = "image")val image : List<ArtistImage>

)

@JsonSerializable
@TypeConverters(ArtistImageConverter::class)
data class ArtistImage (
    @Json(name = "#text") val image_url : String,
    @Json(name = "size") val image_size : String
)
