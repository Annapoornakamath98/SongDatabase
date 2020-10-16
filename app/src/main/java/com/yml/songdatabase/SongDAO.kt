package com.yml.songdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SongDAO {
    @Query("SELECT * FROM song_table")
    fun getWords():List<Songs>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(song: Songs)

    @Query("SELECT songName,singerColumn,movieColumn,durationColumn FROM song_table WHERE songName LIKE :editVal")
    fun getSong(editVal:String):List<Songs>

    @Query("UPDATE song_table SET singerColumn= :editSinger WHERE songName LIKE :editValNew")
    fun setSinger(editSinger:String,editValNew:String)

    @Query("DELETE FROM song_table")
    fun deleteAll()
}