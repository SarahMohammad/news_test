package com.example.testkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.testkotlin.R
import com.example.testkotlin.models.Articles
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val json = intent.getStringExtra("article")
        val article = Gson().fromJson(json, Articles::class.java)
        val title = findViewById<TextView>(R.id.title_id)
        val desc = findViewById<TextView>(R.id.desc_id)
        val image = findViewById<ImageView>(R.id.imageView)
        title.text = article.title
        desc.text = article.content
        Glide.with(this).load(article.urlToImage).into(image)

    }
}