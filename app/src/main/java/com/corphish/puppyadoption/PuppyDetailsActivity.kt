package com.corphish.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.request.RequestOptions
import com.corphish.puppyadoption.data.Constants
import com.corphish.puppyadoption.data.Puppies
import com.corphish.puppyadoption.data.models.Puppy
import com.corphish.puppyadoption.ui.theme.Montserrat
import com.corphish.puppyadoption.ui.theme.PuppyAdoptionTheme
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

class PuppyDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get the puppy id
        val puppyId = intent.getIntExtra(Constants.PUPPY_ID, 0)

        // Get the puppy from id
        val puppy = Puppies.getPuppyById(puppyId)

        setContent {
            PuppyAdoptionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    if (puppy == null) {
                        ErrorLayout()
                    } else {
                        PuppyContent(puppy = puppy) { finish() }
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorLayout() {
    Text(text = "Error", textAlign = TextAlign.Center)
}

/**
 * Main content of the app.
 */
@Composable
fun PuppyContent(puppy: Puppy, closeButtonAction: () -> Unit) {
    IconButton(
        onClick = { closeButtonAction() },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
        )
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(start = 24.dp, top = 32.dp, end = 24.dp, bottom = 8.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                data = puppy.imageURL,
                requestBuilder = {
                    val options = RequestOptions()
                    options.override(384)
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
                    is ImageLoadState.Error -> {/* TODO */
                    }
                    ImageLoadState.Loading -> {/* TODO */
                    }
                    ImageLoadState.Empty -> {/* TODO */
                    }
                }
            }
        }

        Text(text = puppy.name, style = MaterialTheme.typography.h2)
        Text(text = puppy.breed, style = MaterialTheme.typography.button, fontSize = 20.sp)
        Text(text = "${puppy.age} old", style = MaterialTheme.typography.body1)
        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 8.dp,vertical = 16.dp)
                .clip(RoundedCornerShape(16.dp)),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
                Text("ADOPT",
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    style = TextStyle(
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = Montserrat
                    ),
                    fontSize = 16.sp
                )
            }
        }
        Text(
            text = "❤ Adopted by ${puppy.adoptionCount} people",
            style = MaterialTheme.typography.caption
        )
        Text(
            text = "Bio",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        )
        Text(
            text = puppy.description,
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PuppyAdoptionTheme {
        ErrorLayout()
    }
}