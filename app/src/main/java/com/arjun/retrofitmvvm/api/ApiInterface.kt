package com.arjun.retrofitmvvm.api

import com.arjun.retrofitmvvm.model.JokesDataClass
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("get_memes")
    suspend fun getJokes() : Response<JokesDataClass>
}