package presentation.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import presentation.screens.TitleDetailsScreen
import presentation.viewmodels.TitleDetailsViewModel

internal const val titleDetailsScreenRoute = "titleDetails"
internal const val titleIdArgument = "titleId"

fun NavGraphBuilder.titleDetailsScreen(
    onPopBackStack: () -> Unit
) {
    composable("$titleDetailsScreenRoute/{$titleIdArgument}") { backStackEntry->

        backStackEntry.arguments?.getString(titleIdArgument)?.let { _ ->
            val viewModel = viewModel<TitleDetailsViewModel>(
                factory = TitleDetailsViewModel.Factory
            )

            val uiState by viewModel.uiState.collectAsState()

            TitleDetailsScreen(uiState)

        } ?: LaunchedEffect(Unit) {
            onPopBackStack()
        }

    }
}

fun NavController.navigateToTitleDetails(
    movieId:Int,
    navOptions: NavOptions? = null
) {
    navigate("$titleDetailsScreenRoute/$movieId", navOptions)
}
