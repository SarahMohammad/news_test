package com.example.testkotlin.viewmodel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.example.testkotlin.models.ArticlesReponse
import com.example.testkotlin.repository.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    var mutableLivedata = MutableLiveData<ArticlesReponse>()

    fun getNews(source:String , key:String) : LiveData<ArticlesReponse>{
        //asynchronous API call using Retrofit's enqueue method,
        // which operates on a separate thread to avoid blocking the main UI thread.
        ApiClient.api.getNews(source ,key).enqueue(object: Callback<ArticlesReponse>{
            override fun onResponse(call: Call<ArticlesReponse>, response: Response<ArticlesReponse>) {
                if (response.body()!=null){
                    mutableLivedata.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<ArticlesReponse>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
        return mutableLivedata
    }

    fun observeNewsLiveData() : LiveData<ArticlesReponse> {
        return mutableLivedata
    }
}
