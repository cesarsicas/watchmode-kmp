package presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.api.Repository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.uistate.SearchUiState

class SearchViewModel : ViewModel() {
    private val repository = Repository()
    private val _uiState = MutableStateFlow(SearchUiState())
    private var searchJob: Job? = null
    val uiState = _uiState.asStateFlow()


    init {
        _uiState.update { currentState ->
            currentState.copy(
                onSearchChange = {
                    _uiState.value = _uiState.value.copy(
                        searchText = it
                    )

                    search(it)
                }
            )
        }
    }


    private fun search(search: String) {
        searchJob?.cancel() //todo check if there is a better way to do this
        searchJob = viewModelScope.launch {
            try {
                _uiState.update { currentState ->
                    currentState.copy(
                        result = repository.getSearch(search)
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()

                _uiState.update { currentState ->
                    currentState.copy(
                        result = listOf()
                    )
                }
            }
        }
    }
}
