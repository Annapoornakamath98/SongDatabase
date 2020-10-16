package com.yml.songdatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase

class UpdateSingerActivity : AppCompatActivity() {
    private lateinit var searchBtn:Button
    private lateinit var updateBtn:Button
    private lateinit var edSearch:EditText
    private lateinit var edUpdate:EditText
    private lateinit var textView:TextView
    private lateinit var database: SongsRoomDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_singer)
        searchBtn=findViewById(R.id.btnSearch)
        updateBtn=findViewById(R.id.btnUpdate)
        edSearch=findViewById(R.id.searchSong)
        edUpdate=findViewById(R.id.editUpdate)
        textView=findViewById(R.id.displaySongs)
        database= Room.databaseBuilder(this,SongsRoomDatabase::class.java,"word_database").build()
        @SuppressLint("SetTextI18n")
        fun readData(){
            val list:ArrayList<Songs> = ArrayList()
            Thread{
                list.addAll(database.wordDao().getSong(edSearch.text.toString()))
                textView.post {
                    if(list.isEmpty())
                        Toast.makeText(this,"Empty",Toast.LENGTH_SHORT).show()
                    else{
                        val uList:ArrayList<String> = ArrayList()
                        list.forEach{uList.add(it.word)
                            uList.add(it.singer)
                            uList.add(it.movie)
                            uList.add(it.dur)
                        }
                        textView.setText("Song Name: "+uList[0]+ "\nSinger: "+uList[1]+"\nMovie: "+uList[2]+"\nSong Duration: "+uList[3])
                    }
                }
            }.start()
        }

        fun getSinger(){
            val list2:ArrayList<Songs> = ArrayList()
            Thread{
                //list2.addAll(database.wordDao().setSinger(edUpdate.text.toString(),edSearch.text.toString()))
                database.wordDao().setSinger(edUpdate.text.toString(),edSearch.text.toString())
            }.start()
            Toast.makeText(applicationContext,"Changed",Toast.LENGTH_SHORT).show()
        }

        searchBtn.setOnClickListener {
                readData()
        }
        updateBtn.setOnClickListener {
            getSinger()
        }

    }
}