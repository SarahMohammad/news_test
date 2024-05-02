package com.example.testkotlin.activity;

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testkotlin.MyCustomAdapter
import com.example.testkotlin.R
import com.example.testkotlin.viewmodel.NewsViewModel


class MainActivity : AppCompatActivity() {
     private val apiKey : String = "71d9e0fec5f44e4291290230a9089771"
    //lateinit keyword means that the variable will be initialized later before its first usage.
     lateinit var myListView : ListView
     private lateinit var viewModel: NewsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set the layout of the activity to be displayed from the XML file
        setContentView(R.layout.activity_main)
         myListView = findViewById(R.id.listView)
        //ViewModel instance of type NewsViewModel is initialized using a ViewModelProvider.
        // This allows the activity to interact with the NewsViewModel class.
         viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
         viewModel.getNews("bbc-news", apiKey)
        //set up an observer to listen for changes in the news data obtained from the viewModel.
        // When new data is received, it updates the ListView with a custom adapter called MyCustomAdapter
         viewModel.observeNewsLiveData().observe(this, Observer { ArticlesReponse ->
             myListView.adapter = MyCustomAdapter(ArticlesReponse.articles, this@MainActivity)
         })

     }
}