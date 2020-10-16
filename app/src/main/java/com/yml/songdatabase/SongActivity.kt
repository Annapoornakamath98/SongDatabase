package com.yml.songdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class SongActivity : AppCompatActivity() {
    private lateinit var editSong: EditText
    private lateinit var edSinger: EditText
    private lateinit var edMovie: EditText
    private lateinit var edDuration: EditText
    private lateinit var database: SongsRoomDatabase
    lateinit var roomInsert: Button
    lateinit var roomSearch: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_activity)
        roomInsert=findViewById(R.id.roomdone)
        editSong=findViewById(R.id.roomEdit1)
        roomSearch=findViewById(R.id.search)
        edSinger=findViewById(R.id.editSinger)
        edMovie=findViewById(R.id.editMovie)
        edDuration=findViewById(R.id.editDuration)
        database= Room.databaseBuilder(this,SongsRoomDatabase::class.java,"word_database").build()

        roomSearch.setOnClickListener {
            intent= Intent(applicationContext,UpdateSingerActivity::class.java)
            startActivity(intent)
        }
        fun insertData(item:Songs){
            Thread{
                database.wordDao().insert(item)
                //database.wordDao().deleteAll()

            }.start()
        }

        roomInsert.setOnClickListener {
                insertData(
                    Songs(
                        editSong.text.toString(),
                        edSinger.text.toString(),
                        edMovie.text.toString(),
                        edDuration.text.toString()
                    )
                )

            Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
        }



    }
}