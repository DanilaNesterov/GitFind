package com.example.lab23.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab23.model.RepositoryList


@Composable
fun RepositoryList(
    repositoryList: RepositoryList,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(repositoryList.items) { repository ->
            RepositoryCard(
                repository = repository,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        
    }
}