package com.example.testkotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.testkotlin.activity.DetailActivity
import com.example.testkotlin.models.Articles
import com.google.gson.Gson

class MyCustomAdapter(val myDataList : List<Articles>, val ctx : Context) : BaseAdapter() {
    override fun getCount(): Int {
        return myDataList.size
    }

    override fun getItem(position: Int): Articles {
        return myDataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myConvertView =  convertView
        if(myConvertView == null){
            myConvertView = LayoutInflater.from(ctx).inflate(R.layout.row_item , parent , false)
        }
        val currentItem = getItem(position)
        val imageItem = myConvertView?.findViewById<ImageView>(R.id.item_image)
        val title = myConvertView?.findViewById<TextView>(R.id.item_title)
        val desc = myConvertView?.findViewById<TextView>(R.id.item_desc)

        if (imageItem != null) {
            Glide.with(ctx)
                .load(currentItem.urlToImage)
                .into(imageItem)

        }

        title?.text = currentItem.title
        desc?.text = currentItem.content

        myConvertView!!.setOnClickListener {
            val clickedItem = getItem(position)
            val intent = Intent(ctx, DetailActivity::class.java)
            intent.putExtra("article", Gson().toJson(clickedItem))
            ctx.startActivity(intent)
        }

        return myConvertView
    }

}