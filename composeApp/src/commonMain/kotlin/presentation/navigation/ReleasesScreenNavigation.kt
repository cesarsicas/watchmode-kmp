package presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import domain.Title
import presentation.screens.ReleasesScreen
import presentation.viewmodels.ReleasesViewModel

internal const val releasesListNavigationRoutes = "releases"


fun NavGraphBuilder.releasesListScreen(
    onMovieClick: (Title) -> Unit
) {
    composable(releasesListNavigationRoutes) {
        val viewModel: ReleasesViewModel = viewModel<ReleasesViewModel>()
        val state = viewModel.uiState.collectAsState().value

        ReleasesScreen(
            uiState = state,
            onMovieClick = onMovieClick
        )
    }

}


fun NavController.navigateToReleasesList(
    navOptions: NavOptions? = null
) {
    navigate(releasesListNavigationRoutes, navOptions)
}
