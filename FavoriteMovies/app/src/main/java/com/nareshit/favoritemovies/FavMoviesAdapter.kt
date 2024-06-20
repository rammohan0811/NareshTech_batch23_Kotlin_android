package com.nareshit.favoritemovies

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class FavMoviesAdapter(val context:Context, val movies:List<MovieInfo>) :Adapter<FavMoviesAdapter.FavMoviesVH>() {

    class FavMoviesVH(v:View):ViewHolder(v){
        val iv:ImageView = v.findViewById(R.id.movie_poster_iv)
        val mn:TextView = v.findViewById(R.id.movie_name_tv)
        val an:TextView = v.findViewById(R.id.actors_names_tv)
    }

    // You are attaching a layout file along with the view information (Viewholder class)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMoviesVH {
        val v:View = LayoutInflater.from(context).inflate(R.layout.one_item_design,parent,false)
        return FavMoviesVH(v)
    }

    // this returns the total number of items on recyclerview
    override fun getItemCount(): Int {
        return movies.size
    }

    // Here you will populate the data
    override fun onBindViewHolder(holder: FavMoviesVH, position: Int) {
        holder.iv.setImageResource(movies.get(position).poster)
        holder.mn.text = movies.get(position).name
        holder.an.text = ""
        for(i in movies.get(position).actors){
            holder.an.append("$i ")
        }
    }
}