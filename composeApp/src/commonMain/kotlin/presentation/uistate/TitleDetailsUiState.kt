package presentation.uistate

import domain.Title


data class TitleDetailsUiState(
    val title: Title? = null,
    val isLoading: Boolean = false,
    val error: String? = null

)