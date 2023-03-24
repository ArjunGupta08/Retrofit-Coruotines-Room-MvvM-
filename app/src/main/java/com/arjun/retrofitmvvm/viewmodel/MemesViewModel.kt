package com.arjun.retrofitmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjun.retrofitmvvm.model.JokesDataClass
import com.arjun.retrofitmvvm.repository.MemesRepositiory
import com.arjun.retrofitmvvm.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel(private val memesRepositiory: MemesRepositiory) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            memesRepositiory.getMeme()
        }
    }

    val memes : LiveData<Response<JokesDataClass>>
    get() = memesRepositiory.memes
}