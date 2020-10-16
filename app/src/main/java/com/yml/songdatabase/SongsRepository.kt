package com.yml.songdatabase

class SongsRepository(private val wordDAO: SongDAO) {
    val allWords:List<Songs> = wordDAO.getWords()
    //val allSongs:List<Songs> =wordDAO.getSong(editVal = String())
    fun insert(wordc: Songs){
        wordDAO.insert(wordc)
    }
   
//    fun insertSinger(singer: Wordc){
//        wordDAO.insertSinger(singer)
//    }
//    fun insertMovie(movie: Wordc){
//        wordDAO.insertMovie(movie)
//    }
//    fun insertDuration(duration: Wordc){
//        wordDAO.insertDuration(duration)
//    }
}