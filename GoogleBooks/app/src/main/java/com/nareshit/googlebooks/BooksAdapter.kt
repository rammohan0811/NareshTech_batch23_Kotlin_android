package com.nareshit.googlebooks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class BooksAdapter(val context:Context, val sd:Source): Adapter<BooksAdapter.BooksVH>() {
    class BooksVH(val v:View):ViewHolder(v){
        val iv:ImageView = v.findViewById(R.id.imageView)
        val bn:TextView = v.findViewById(R.id.book_title)
        val an:TextView = v.findViewById(R.id.book_authors)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        val v:View = LayoutInflater.from(context).inflate(R.layout.one_item_design,parent,false)
        return BooksVH(v)
    }

    override fun getItemCount(): Int {
        return sd.items.size
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        Glide.with(context).load(sd.items?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail).into(holder.iv)
        holder.bn.text = sd.items?.get(position)?.volumeInfo?.title
        holder.an.text = sd.items?.get(position)?.volumeInfo?.authors?.get(0)
    }
}