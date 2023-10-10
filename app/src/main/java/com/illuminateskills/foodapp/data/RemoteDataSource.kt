package com.illuminateskills.foodapp.data

import com.illuminateskills.foodapp.data.network.interfaces.FoodRecipesApi
import com.illuminateskills.foodapp.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    fun getRecipes(queries: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)
    }

}