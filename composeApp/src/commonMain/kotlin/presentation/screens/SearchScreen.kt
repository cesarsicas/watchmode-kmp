package presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.components.MoviesVerticalList
import presentation.components.SearchTextField
import domain.Title
import domain.titlesSample
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.uistate.SearchUiState

@Composable
fun SearchScreen(
    uiState: SearchUiState,
    onTitleClick: (Title) -> Unit,
) {
    val text = uiState.searchText
    val searchResult = uiState.result

    Column {

        SearchTextField(
            searchText = text,
            onSearchChange = uiState.onSearchChange,
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        MoviesVerticalList(titles = searchResult, onTitleClick)
    }


}


@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreen(SearchUiState()){}
}


@Preview
@Composable
private fun SearchScreenPreviewWithValue() {
    SearchScreen(SearchUiState(titlesSample)){}
}





