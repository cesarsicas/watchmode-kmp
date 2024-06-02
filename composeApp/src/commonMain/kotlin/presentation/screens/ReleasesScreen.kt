package presentation.screens

import androidx.compose.runtime.Composable
import presentation.components.MovieGrid
import domain.Title
import domain.titlesSample
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.uistate.ReleasesUiState


@Composable
fun ReleasesScreen(
    uiState: ReleasesUiState,
    onMovieClick: (Title) -> Unit = {}
) {
    MovieGrid(
        uiState.releases,
        onMovieClick = onMovieClick
    )

}


@Preview
@Composable
private fun ReleasesScreenPreview() {
    ReleasesScreen(uiState = ReleasesUiState(titlesSample))
}

