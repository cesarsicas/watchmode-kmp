package presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.api.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.uistate.ReleasesUiState

class ReleasesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReleasesUiState())
    val uiState = _uiState.asStateFlow()

    init {


        viewModelScope.launch {


            val repository = Repository()

            try {
                val result = repository.getReleases()

                _uiState.update {
                    it.copy(releases = result)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}