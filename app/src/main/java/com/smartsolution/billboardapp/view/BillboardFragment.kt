package com.smartsolution.billboardapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.smartsolution.billboardapp.R
import com.smartsolution.billboardapp.databinding.FragmentBillboardBinding
import com.smartsolution.billboardapp.model.network.MovieModel
import com.smartsolution.billboardapp.viewmodel.MovieListViewModel
import com.smartsolution.billboardapp.view.adapter.MoviesAdapter
import com.smartsolution.billboardapp.viewmodel.MovieViewModel

class BillboardFragment : Fragment() {

    private var _binding: FragmentBillboardBinding? = null
    private lateinit var adapter: MoviesAdapter
    private val movieListviewModel: MovieListViewModel by viewModels()
    private val movieViewModel: MovieViewModel by activityViewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        movieListviewModel.getBillboard()

        movieListviewModel.listMovies.observe(viewLifecycleOwner) {
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
        movieViewModel.setMovie(movie)
        findNavController().navigate(R.id.action_navigation_billboard_to_navigation_movie)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}