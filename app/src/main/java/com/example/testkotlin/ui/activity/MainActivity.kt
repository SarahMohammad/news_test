package com.example.testkotlin.ui.activity;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.testkotlin.R


class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController
//     private val apiKey : String = "71d9e0fec5f44e4291290230a9089771"
    //lateinit keyword means that the variable will be initialized later before its first usage.
//     lateinit var myListView : ListView
//     private lateinit var viewModel: NewsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set the layout of the activity to be displayed from the XML file
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
         //myListView = findViewById(R.id.listView)
        //ViewModel instance of type NewsViewModel is initialized using a ViewModelProvider.
        // This allows the activity to interact with the NewsViewModel class.
//         viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
//         viewModel.getNews("bbc-news", apiKey)
//        //set up an observer to listen for changes in the news data obtained from the viewModel.
//        // When new data is received, it updates the ListView with a custom adapter called com.example.testkotlin.ui.activity.fragments.MyCustomAdapter
//         viewModel.observeNewsLiveData().observe(this, Observer { ArticlesReponse ->
//             myListView.adapter = com.example.testkotlin.ui.activity.fragments.MyCustomAdapter(ArticlesReponse.articles, this@MainActivity)
//         })

     }
}