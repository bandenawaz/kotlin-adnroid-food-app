package com.illuminateskills.foodapp.ui.fragments.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.illuminateskills.foodapp.MainViewModel
import com.illuminateskills.foodapp.R
import com.illuminateskills.foodapp.adapters.RecipesAdapter
import com.illuminateskills.foodapp.util.Constants
import com.illuminateskills.foodapp.util.NetworkResult
import com.todkars.shimmer.ShimmerRecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var shimmerRecyclerView: ShimmerRecyclerView
    private val mAdapter by lazy { RecipesAdapter()}
    private lateinit var mainViewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_recipies, container, false)

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        shimmerRecyclerView = mView.findViewById(R.id.shimmerRecyclerView)
        shimmerRecyclerView.showShimmer()
        setUpRecyclerView()
        requestApiData()
        return mView
    }

    private fun requestApiData() {
        mainViewModel.getRecipes(applyQueries())
        mainViewModel.recipesResponse.observe(viewLifecycleOwner, Observer{ response ->
            when (response){
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    Toast.makeText(requireContext(),response.message, Toast.LENGTH_SHORT).show()
                }

                is NetworkResult.Loading -> {
                    showShimmerEffect()
                }
            }
        })
    }

    private fun applyQueries(): HashMap<String, String> {

        val queries: HashMap<String, String> = HashMap()

        queries["number"] = "50"
        queries["apiKey"] = Constants.API_KEY
        queries["type"] = "snack"
        queries["diet"] = "vegan"
        queries["addRecipeInformation"] = "true"
        queries["fillIngredients"] = "true"

        return queries
    }
    private fun setUpRecyclerView(){
        shimmerRecyclerView.adapter = mAdapter
        shimmerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }
    private fun showShimmerEffect(){
        shimmerRecyclerView.showShimmer()
    }

    fun hideShimmerEffect(){
        shimmerRecyclerView.hideShimmer()
    }
}