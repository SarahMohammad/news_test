package com.example.testkotlin.ui.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testkotlin.R
import com.example.testkotlin.domain.entity.Articles
import com.bumptech.glide.Glide

class NewsListAdapter(
    private val myDataList: List<Articles>,
    private val navController: NavController,
) : RecyclerView.Adapter<NewsListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myDataList[position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            navController.navigate(R.id.action_list_fragment_to_details_fragment)
        }
    }

    override fun getItemCount(): Int {
        Log.d("Adapter", "Data size: ${myDataList.size}")
        return myDataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageItem = itemView.findViewById<ImageView>(R.id.item_image)
        private val title = itemView.findViewById<TextView>(R.id.item_title)
        private val desc = itemView.findViewById<TextView>(R.id.item_desc)

        fun bind(article: Articles) {
            Glide.with(itemView.context)
                .load(article.urlToImage)
                .into(imageItem)
            title.text = article.title
            desc.text = article.content
        }
    }
}
