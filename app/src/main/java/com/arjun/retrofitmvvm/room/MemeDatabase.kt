package com.arjun.retrofitmvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arjun.retrofitmvvm.model.Meme

@Database(entities = [Meme::class], version = 1)
abstract class MemeDatabase : RoomDatabase(){

    abstract fun memeDao() : RoomDao

    companion object{

        @Volatile
        private var INSTANCE : MemeDatabase? = null

        fun getDatabase(context: Context): MemeDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
                synchronized(this) {
                   val instance = Room.databaseBuilder(
                        context,
                        MemeDatabase::class.java,
                        "memesdb"
                    ).build()
                    INSTANCE = instance
                    return instance!!
                }
        }
    }
}