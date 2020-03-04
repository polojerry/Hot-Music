package com.polotechnologies.hotmusic.database.typeConverters

import androidx.room.TypeConverter
import com.polotechnologies.hotmusic.dataModel.ArtistImage

class ArtistImageConverter {

    @TypeConverter
    fun toString(artistImage: ArtistImage?): String {
        var artistImages = ""

        if (artistImage == null) {
            return artistImages
        } else {
            artistImages = "${artistImage.image_size}," +
                    artistImage.image_url
        }

        return artistImages

    }

    @TypeConverter
    fun toArtistImage(artistImages: String?): ArtistImage? {

        var artistImage: ArtistImage? = ArtistImage(
            "", ""
        )

        return if (artistImages.equals("")) {

            artistImage

        } else {

            val artistImageList: List<String> = artistImages!!.split(",")

            artistImage = ArtistImage(
                artistImageList[0],
                artistImageList[1]
            )

            artistImage
        }
    }
}