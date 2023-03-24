package com.arjun.retrofitmvvm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arjun.retrofitmvvm.model.Meme

@Dao
interface RoomDao {
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeme(meme : List<Meme>)

    @Query("SELECT * FROM memes")
    fun getMemes() : List<Meme>
}