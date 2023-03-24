package com.arjun.retrofitmvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arjun.retrofitmvvm.api.ApiInterface
import com.arjun.retrofitmvvm.model.Data
import com.arjun.retrofitmvvm.model.JokesDataClass
import com.arjun.retrofitmvvm.room.MemeDatabase
import com.arjun.retrofitmvvm.util.MyUtils

class MemesRepositiory(
    private val apiInterface: ApiInterface,
    private val memeDatabase: MemeDatabase,
    private val applicationContext: Context){

    private val memesLiveData = MutableLiveData<Response<JokesDataClass>>()

    val memes : LiveData<Response<JokesDataClass>>
    get() = memesLiveData

    suspend fun getMeme(){
        if (MyUtils.isInternetAvailable(applicationContext)){
            try {
                val result = apiInterface.getJokes()
                if (result.body() != null){
                    memeDatabase.memeDao().insertMeme(result.body()!!.data.memes)
                    memesLiveData.postValue(Response.Success(result.body()))
                }
            }
            catch (e:Exception){
                 memesLiveData.postValue(Response.Error(e.message.toString()))
            }
        }
        else{
            val memes = memeDatabase.memeDao().getMemes()
            val memeList = JokesDataClass(Data(memes),true)
            memesLiveData.postValue(Response.Success(memeList))
        }
    }
}