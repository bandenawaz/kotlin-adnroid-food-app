package com.illuminateskills.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
import com.todkars.shimmer.ShimmerRecyclerView

class RecipiesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipies, container, false)

        val shimmerRecyclerView: ShimmerRecyclerView = view.findViewById(R.id.shimmerRecyclerView)
        shimmerRecyclerView.showShimmer()
        return view
    }

}