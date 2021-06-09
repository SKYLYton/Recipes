package com.recipes.fragments.search_recipe

import com.recipes.retrofit.RetrofitCallback
import com.recipes.retrofit.model.ApiRequest
import com.recipes.retrofit.model.ApiResponseListener
import com.recipes.retrofit.model.recipe.ResultRecipeModel
import retrofit2.Call

class SearchRestRepositoryImpl (private val apiRequest: ApiRequest) : SearchRestRepository {
    override fun search(
        q: String,
        apiResponseListener: ApiResponseListener<ResultRecipeModel?>?
    ): Call<ResultRecipeModel?> {
        val call = apiRequest.getRecipes(q)
        call!!.enqueue(RetrofitCallback(apiResponseListener))
        return call
    }
}