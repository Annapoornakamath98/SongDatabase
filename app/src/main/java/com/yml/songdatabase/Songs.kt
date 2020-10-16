package com.yml.songdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "song_table")
class Songs(@PrimaryKey @ColumnInfo(name="songName") val word:String, @ColumnInfo(name = "singerColumn") val singer:String,
            @ColumnInfo(name = "movieColumn") val movie:String, @ColumnInfo(name = "durationColumn") val dur:String)