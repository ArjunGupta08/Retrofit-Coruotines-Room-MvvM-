package com.arjun.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arjun.retrofitmvvm.repository.Response
import com.arjun.retrofitmvvm.viewmodel.MemesViewModel
import com.arjun.retrofitmvvm.viewmodel.MemesViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var memesViewModel: MemesViewModel

    val recyclerView : RecyclerView
    get() = findViewById(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as MyApplication).memesRepositiory

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        memesViewModel = ViewModelProvider(this,MemesViewModelFactory(repository)).get(MemesViewModel::class.java)

        memesViewModel.memes.observe(this) {

            when(it){
                is Response.Loading ->{}

                is Response.Success -> {
                    it.data?.let {
                        // SetUp Adapter --->
                        val newAdapter = Adapter(applicationContext,it.data.memes)
                        recyclerView.adapter = newAdapter
                        newAdapter.notifyDataSetChanged()
                        Toast.makeText(applicationContext, "Size : ${it.data.memes.size}", Toast.LENGTH_SHORT)
                            .show()
                        it.data.memes.iterator().forEach {
                            Log.d("get", "\nName : ${it.name}")
                        }
                    }
                }

                is Response.Error -> {
                    Toast.makeText(applicationContext,it.errorMessage.toString(),Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}