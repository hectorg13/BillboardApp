package com.smartsolution.billboardapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smartsolution.billboardapp.R
import com.smartsolution.billboardapp.databinding.ItemRecyclerMoviesBinding
import com.smartsolution.billboardapp.model.Constants
import com.smartsolution.billboardapp.model.network.MovieModel

class MoviesAdapter(
    var listMovies: List<MovieModel>,
    private val onClickListener: (MovieModel) -> Unit
) :
    RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder(
            layoutInflater.inflate(
                R.layout.item_recycler_movies,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = listMovies[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = listMovies.size
}

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemRecyclerMoviesBinding.bind(itemView)
    fun render(movie: MovieModel, onClickListener: (MovieModel) -> Unit) {
        binding.tvMovieTitle.text = movie.originalTitle
        Glide.with(binding.ivMoviePoster.context)
            .load("${Constants.BASE_URL_IMAGEN}${movie.posterPath}")
            .apply(RequestOptions().override(Constants.IMAGEN_ANCHO, Constants.IMAGEN_ALTO))
            .into(binding.ivMoviePoster)
        itemView.setOnClickListener {
            onClickListener(movie)
        }
    }
}
