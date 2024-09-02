package com.example.lab23.data

import com.example.lab23.model.RepositoryList
import com.example.lab23.network.ApiService
import javax.inject.Inject

interface MainRepository {
    suspend fun searchRepositories(query: String): RepositoryList
}

class NetworkMainRepository @Inject constructor(
    private val apiService: ApiService
): MainRepository {
    override suspend fun searchRepositories(query: String): RepositoryList {
        return apiService.searchRepositories(query)
    }
}