package presentation.uistate

import domain.Title


data class SearchUiState(
    val result: List<Title> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {},
    val isLoading: Boolean = false,
    val error: String? = null

)