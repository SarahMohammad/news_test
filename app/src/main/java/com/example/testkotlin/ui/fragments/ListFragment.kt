package com.example.testkotlin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testkotlin.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private val apiKey: String = "71d9e0fec5f44e4291290230a9089771"

    //lateinit keyword means that the variable will be initialized later before its first usage.
    private lateinit var viewModel: NewsViewModel
    private var binding: FragmentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ViewModel instance of type NewsViewModel is initialized using a ViewModelProvider.
        // This allows the activity to interact with the NewsViewModel class.
        binding?.let {

            viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
            viewModel.getNews("bbc-news", apiKey)
            //set up an observer to listen for changes in the news data obtained from the viewModel.
            // When new data is received, it updates the ListView with a custom adapter called com.example.testkotlin.ui.activity.fragments.MyCustomAdapter
            viewModel.observeNewsLiveData()
                .observe(viewLifecycleOwner) { ArticlesResponse ->
                    it.listView.adapter =
                        NewsListAdapter(ArticlesResponse.articles, findNavController())

                }
        }
    }

}
