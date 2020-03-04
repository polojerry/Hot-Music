/*
package com.polotechnologies.hotmusic.database.typeConverters

import androidx.room.TypeConverter
import com.polotechnologies.hotmusic.dataModel.Artist
import com.polotechnologies.hotmusic.dataModel.ArtistImage


class ArtistImageConverter {
    @TypeConverter
    fun toString(artistImages : List<Artist>) : String{
        val images = ""

        if(artistImages.isEmpty()){
            return images
        }
        else{
            for (image  in artistImages){
                images.plus(image).plus("")
            }
        }

        return images
    }

    @TypeConverter
    fun toArtistImageList(artistImagesString : String) : List<Artist>{
        val artistImages = listOf<Artist>()

        if(artistImagesString == ""){
            return artistImages
        }else{
            val artist = artistImagesString.split("")
            for (image in artist){
                val artistImage  = ArtistImage(
                    artist[0],
                    artist[1]
                )
                artistImages.plus(artistImage)
            }

        }

        return artistImages

    }


}
*/
