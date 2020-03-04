package com.polotechnologies.hotmusic.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polotechnologies.hotmusic.dataModel.Artist

@Dao
interface HotMusicDao {

    @Query("SELECT * FROM top_artists_table")
    fun getTopArtists() : LiveData<List<Artist>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopArtists(vararg artist: Artist)
}