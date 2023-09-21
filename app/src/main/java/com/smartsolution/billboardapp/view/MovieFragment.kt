package com.smartsolution.billboardapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smartsolution.billboardapp.databinding.FragmentMovieBinding
import com.smartsolution.billboardapp.model.Constants
import com.smartsolution.billboardapp.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val movieViewModel: MovieViewModel by activityViewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.currentMovie.observe(viewLifecycleOwner) {
            binding.tvTitleBig.text = it.originalTitle
            binding.tvTitle.text = it.originalTitle
            binding.tvOverview.text = it.overview

            Glide.with(binding.ivPoster.context)
                .load("${Constants.BASE_URL_IMAGEN}${it.posterPath}")
                .into(binding.ivPoster)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}