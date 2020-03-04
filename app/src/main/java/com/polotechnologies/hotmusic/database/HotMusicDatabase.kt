/*
package com.polotechnologies.hotmusic.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.polotechnologies.hotmusic.dataModel.Artist
import com.polotechnologies.hotmusic.database.typeConverters.ArtistImageConverter

@Database(entities = [Artist::class], version = 1, exportSchema = false)
@TypeConverters(ArtistImageConverter::class)
abstract class HotMusicDatabase: RoomDatabase() {

    abstract val hotMusicDao : HotMusicDao

    companion object{
        @Volatile
        private var INSTANCE : HotMusicDatabase? = null

        fun getInstance(context: Context) : HotMusicDatabase {
            synchronized(this){
                var instance =
                    INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HotMusicDatabase::class.java,
                        "hot_music_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance

            }
        }

    }

}*/
