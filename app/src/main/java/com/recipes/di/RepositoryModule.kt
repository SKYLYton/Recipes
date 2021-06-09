package com.recipes.di

import com.recipes.fragments.search_recipe.SearchRestRepositoryImpl
import com.recipes.retrofit.model.ApiRequest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(): ApiRequest? {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiRequest.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiRequest::class.java)
    }

    @Provides
    fun provideSearchRepository(apiRequest: ApiRequest): SearchRestRepositoryImpl {
        return SearchRestRepositoryImpl(apiRequest)
    }
}