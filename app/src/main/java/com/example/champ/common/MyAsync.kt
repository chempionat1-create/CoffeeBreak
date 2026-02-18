package com.example.champ.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.champ.R

@Composable
fun MyAsync(url: String, modifier: Modifier = Modifier, contentScale: ContentScale? = null) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build(),
        contentDescription = null,
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.error),
        modifier = modifier,
        contentScale = contentScale?: ContentScale.Fit

    )
}