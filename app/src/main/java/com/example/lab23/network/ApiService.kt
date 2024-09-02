package com.example.lab23.network

import com.example.lab23.model.RepositoryList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/repositories")
    suspend fun searchRepositories(@Query("q") query: String): RepositoryList
}