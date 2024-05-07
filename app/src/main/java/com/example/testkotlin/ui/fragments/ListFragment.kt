package com.example.testkotlin.ui.fragments

import NavControllerProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.R

class ListFragment : Fragment() , NavControllerProvider {

    override fun provideNavController(): NavController {
        return findNavController()
    }
    private val apiKey : String = "71d9e0fec5f44e4291290230a9089771"
    //lateinit keyword means that the variable will be initialized later before its first usage.
    lateinit var myListView : RecyclerView
    private lateinit var viewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        myListView = view.findViewById(R.id.listView)
        //ViewModel instance of type NewsViewModel is initialized using a ViewModelProvider.
        // This allows the activity to interact with the NewsViewModel class.
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.getNews("bbc-news", apiKey)
        //set up an observer to listen for changes in the news data obtained from the viewModel.
        // When new data is received, it updates the ListView with a custom adapter called com.example.testkotlin.ui.activity.fragments.MyCustomAdapter
        viewModel.observeNewsLiveData().observe(viewLifecycleOwner, Observer {ArticlesResponse ->
            myListView.adapter = NewsListAdapter(ArticlesResponse.articles , this.provideNavController() )

        })

        return view
    }

}
