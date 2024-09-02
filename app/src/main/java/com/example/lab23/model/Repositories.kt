package com.example.lab23.model

import com.google.gson.annotations.SerializedName


data class RepositoryList(
    val items: List<Repository>
)

data class Repository(
    val name: String,
    val owner: Owner,
    @SerializedName("html_url")
    val htmlUrl: String,
    val description: String,
    val language: String
)

data class Owner(
    val login: String,
    @SerializedName("html_url")
    val htmlUrl: String
)