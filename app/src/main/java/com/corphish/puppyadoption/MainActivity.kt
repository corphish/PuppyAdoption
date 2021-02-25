package com.corphish.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.corphish.puppyadoption.data.models.Puppy
import com.corphish.puppyadoption.ui.theme.PuppyAdoptionTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import com.bumptech.glide.request.RequestOptions
import com.corphish.puppyadoption.data.Puppies
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainLayout()
                }
            }
        }
    }
}

/**
 * Main layout of the app.
 */
@Composable
fun MainLayout() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                    )
                },
                backgroundColor = MaterialTheme.colors.background,
                elevation = 2.dp
            )
        },
        content = { MainContent() }
    )
}

/**
 * Main content of the app.
 */
@Composable
fun MainContent() {
    PuppyList(puppies = Puppies.LIST)
}

/**
 * Shows the list of puppies.
 */
@Composable
fun PuppyList(puppies: List<Puppy>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(puppies) {
            PuppyItem(puppy = it)
        }
    }
}

/**
 * Shows one puppy.
 */
@Composable
fun PuppyItem(puppy: Puppy) {
    Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
        GlideImage(
            data = puppy.imageURL,
            requestBuilder = {
                val options = RequestOptions()
                options.override(160)
                options.circleCrop()

                apply(options)
            }
        ) { imageState ->
            when (imageState) {
                is ImageLoadState.Success -> {
                    MaterialLoadingImage(
                        result = imageState,
                        contentDescription = null,
                        fadeInEnabled = true,
                        fadeInDurationMs = 600,
                        contentScale = ContentScale.Crop,
                    )
                }
                is ImageLoadState.Error -> {/* TODO */ }
                ImageLoadState.Loading -> {/* TODO */}
                ImageLoadState.Empty -> {/* TODO */}
            }
        }

        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = puppy.name, style = MaterialTheme.typography.h6)
            Text(text = puppy.breed, style = MaterialTheme.typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppyAdoptionTheme {
        MainLayout()
    }
}