package com.illuminateskills.foodapp.ui.fragments.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.illuminateskills.foodapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [FavouriteRecipiesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavouriteRecipiesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_recipies, container, false)
    }


}