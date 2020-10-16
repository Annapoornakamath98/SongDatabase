package com.yml.songdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(Songs::class)],version =1,exportSchema = false)
abstract class SongsRoomDatabase: RoomDatabase() {
    abstract fun wordDao(): SongDAO
}

