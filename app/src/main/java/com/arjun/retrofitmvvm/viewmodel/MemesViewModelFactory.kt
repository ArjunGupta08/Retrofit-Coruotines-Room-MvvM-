package com.arjun.retrofitmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arjun.retrofitmvvm.repository.MemesRepositiory

class MemesViewModelFactory(private val memesRepositiory: MemesRepositiory) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memesRepositiory) as T
    }
}