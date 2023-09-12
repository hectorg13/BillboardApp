package com.smartsolution.billboardapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.smartsolution.billboardapp.databinding.FragmentTopRatedBinding
import com.smartsolution.billboardapp.model.network.MovieModel
import com.smartsolution.billboardapp.viewmodel.MovieListViewModel
import com.smartsolution.billboardapp.view.adapter.MoviesAdapter

class TopRatedFragment : Fragment() {

    private var _binding: FragmentTopRatedBinding? = null
    private lateinit var adapter: MoviesAdapter
    private lateinit var viewModel: MovieListViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        _binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.getTopRated()
        viewModel.listMovies.observe(viewLifecycleOwner) {
            adapter.listMovies = it
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvMovies.layoutManager = layoutManager
        adapter = MoviesAdapter(arrayListOf()) { movie ->
            onItemSelected(
                movie
            )
        }
        binding.rvMovies.adapter = adapter
    }

    private fun onItemSelected(movie: MovieModel) {
        Toast.makeText(requireContext(), movie.originalTitle, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}