package com.example.lab23.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab23.data.MainRepository
import com.example.lab23.model.RepositoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


sealed interface UiState {
    data class Success(val repositoryList: RepositoryList) : UiState
    object Loading : UiState
    object Error : UiState
    object Idle : UiState
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    var uiState: UiState by mutableStateOf(UiState.Idle)
        private set

    fun searchRepositories(query: String) {
        viewModelScope.launch {
            uiState = UiState.Loading
            try {
                val result = mainRepository.searchRepositories(query)
                uiState = UiState.Success(result)
            } catch (e: IOException) {
                uiState = UiState.Error
            } catch (e: HttpException) {
                uiState = UiState.Error
            }
        }
    }
}