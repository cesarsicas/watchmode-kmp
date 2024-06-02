import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import domain.titlesSample
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.components.BottomAppBar
import presentation.components.BottomAppBarItem
import presentation.components.bottomAppBarItems
import presentation.navigation.favoritesScreenRoute
import presentation.navigation.navigateSingleTopWithPopUpTo
import presentation.navigation.releasesListNavigationRoutes
import presentation.navigation.searchScreenRoute
import presentation.screens.ReleasesScreen
import presentation.theme.BackgroundColor
import presentation.theme.MyApplicationTheme
import presentation.uistate.ReleasesUiState

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    val backStackEntryState by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntryState?.destination

    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = BackgroundColor
        ) {
            val currentRoute = currentDestination?.route
            val selectedItem by remember(currentDestination) {

                val item = when (currentRoute) {
                    releasesListNavigationRoutes -> BottomAppBarItem.Releases
                    favoritesScreenRoute -> BottomAppBarItem.Favorites
                    searchScreenRoute -> BottomAppBarItem.Search
                    else -> BottomAppBarItem.Releases
                }
                mutableStateOf(item)
            }

            WatchModeApp(
                isShowBottomBar = true,
                isShowTopBar = true,
                bottomAppBarItemSelected = selectedItem,
                onBottomAppBarItemSelectedChange = { item ->
                    navController.navigateSingleTopWithPopUpTo(item)
                },
                content = {
                    presentation.navigation.AppNavHost(navController = navController)
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchModeApp(
    bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    isShowBottomBar: Boolean = false,
    isShowTopBar: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (isShowTopBar) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Watch Mode")
                    },
                )
            }
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Watch Mode")
                },
            )
        },
        bottomBar = {
            if (isShowBottomBar) {
                BottomAppBar(
                    item = bottomAppBarItemSelected,
                    items = bottomAppBarItems,
                    onItemChange = onBottomAppBarItemSelectedChange,
                )
            }
        },
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun WatchModeAppPreview() {
    MyApplicationTheme {
        Surface {
            WatchModeApp(content = {
                ReleasesScreen(uiState = ReleasesUiState(releases = titlesSample))
            })
        }
    }
}
//@Composable
//@Preview
//fun App() {
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
//}