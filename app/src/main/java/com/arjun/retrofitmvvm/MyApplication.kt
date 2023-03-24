package com.arjun.retrofitmvvm

import android.app.Application
import com.arjun.retrofitmvvm.api.ApiInterface
import com.arjun.retrofitmvvm.api.RetrofitObject
import com.arjun.retrofitmvvm.repository.MemesRepositiory
import com.arjun.retrofitmvvm.room.MemeDatabase

class MyApplication : Application() {

    lateinit var memesRepositiory: MemesRepositiory
    override fun onCreate() {
        super.onCreate()

        val apiInterface = RetrofitObject.getInstance().create(ApiInterface::class.java)
        val database = MemeDatabase.getDatabase(applicationContext)
        memesRepositiory = MemesRepositiory(apiInterface,database,applicationContext)
    }

}