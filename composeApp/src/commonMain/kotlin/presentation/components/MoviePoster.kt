package presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import domain.Title
import domain.titlesSample
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import watchmode_kmp.composeapp.generated.resources.Res
import watchmode_kmp.composeapp.generated.resources.new_placeholder

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    title: Title,
    onMovieClick: (Title) -> Unit
) {
    AsyncImage(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onMovieClick(title)
            },
        model = title.poster,
        contentScale = ContentScale.FillWidth,
        error = painterResource( Res.drawable.new_placeholder),
        placeholder = painterResource( Res.drawable.new_placeholder),
        contentDescription = title.title
    )
}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        modifier = Modifier,
        title = titlesSample.first()
    ) {}
}