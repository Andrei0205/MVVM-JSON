package com.example.mvvmjson.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmjson.Model.MovieModel
import com.example.mvvmjson.R
import com.squareup.picasso.Picasso

class MovieListAdapter(var context: Context, var movieModelList: MutableList<MovieModel>):
RecyclerView.Adapter<MovieListAdapter.MyViewmodel> (){
    inner class MyViewmodel(itemView: View): RecyclerView.ViewHolder(itemView) {

        var imgMovie: ImageView
        var txtMovieName:TextView
        var txtTeam: TextView
        var txtCreatedBy: TextView

        init {
            imgMovie = itemView.findViewById(R.id.imgMovie)
            txtMovieName = itemView.findViewById(R.id.txtMovieName)
            txtTeam = itemView.findViewById(R.id.txtTeam)
            txtCreatedBy = itemView.findViewById(R.id.txtCreatedBy)

    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewmodel {
        return MyViewmodel(LayoutInflater.from(context).inflate(R.layout.layout_movie_list,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewmodel, position: Int) {
        Picasso.get().load(movieModelList[position].imageurl).into(holder.imgMovie)
        holder.txtMovieName.text = movieModelList[position].name
        holder.txtTeam.text = movieModelList[position].team
        holder.txtCreatedBy.text = movieModelList[position].createdby

    }

    override fun getItemCount(): Int {
        return movieModelList.size
    }

}