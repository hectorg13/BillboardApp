package com.smartsolution.billboardapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.smartsolution.billboardapp.databinding.FragmentMovieBinding
import com.smartsolution.billboardapp.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private lateinit var viewModel: MovieViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentMovie.observe(viewLifecycleOwner) {
            binding.tvTitleBig.text = it.originalTitle
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}