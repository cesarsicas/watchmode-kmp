package presentation.uistate

import domain.Title


data class ReleasesUiState(
    val releases: List<Title> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null

)