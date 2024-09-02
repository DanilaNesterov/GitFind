package com.example.lab23.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        SearchField(
            query = query,
            onQueryChange = { newQuery ->
                query = newQuery
            },
            search = {
              viewModel.searchRepositories(query)
            },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        when (viewModel.uiState) {
            is UiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
            is UiState.Error -> ErrorScreen(
                retryAction = { viewModel.searchRepositories(query) },
                modifier = Modifier.fillMaxSize()
            )
            is UiState.Success -> RepositoryList(
                repositoryList = (viewModel.uiState as UiState.Success).repositoryList,
                modifier = Modifier.fillMaxSize()
            )
            is UiState.Idle -> {
            }
        }
    }
}