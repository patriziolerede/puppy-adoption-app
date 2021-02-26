/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.catdetail

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Puppy
import com.example.androiddevchallenge.PuppyData
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple200
import dev.chrisbanes.accompanist.coil.CoilImage

private const val START_TOP_PADDING = 180

@Composable
fun PuppyDetail(puppy: Puppy) {
    val context = LocalContext.current as? Activity
    val scrollState = rememberScrollState()

    val imageOffset = (-scrollState.value * 0.2f).dp

    val iconBackgroundAlpha =
        ((scrollState.value / START_TOP_PADDING.toFloat()) * 0.2f).coerceAtMost(0.2f)

    Box(modifier = Modifier.background(Color.White)) {
        Player(
            modifier = Modifier
                .offset(y = imageOffset)
                .fillMaxWidth()
        )
        Column(
            Modifier
                .verticalScroll(scrollState)
                .padding(top = START_TOP_PADDING.dp)
                .background(
                    purple200,
                    CutCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(all = 32.dp)
        ) {
            Text("Cat name:", style = MaterialTheme.typography.h6)
            Text(text = puppy.name, style = MaterialTheme.typography.h3)
            Spacer(Modifier.size(16.dp))
            Row(Modifier.fillMaxWidth()) {
                Detail("Breed \uD83D\uDC31", "Cat")
                PosterCard(
                    puppy = puppy,
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            Color.LightGray,
                            CutCornerShape(topStart = 32.dp, topEnd = 32.dp)
                        )
                        .aspectRatio(16 / 9f)
                )
            }
            Text(text = "${puppy.name} She has lovely, long smoke-colored fur with a white patch. Her fur is like silk. Her eyes are jewel green — they shine like peridots. She is loving and affectionate but is very much “her own cat”. She loves her brother Mischa but often picks fights with him, even though she is significantly smaller. Mischa is like lightning, therefore no pictures of him as yet.\n\n$LORIM")
        }

        IconButton(
            onClick = { context?.onBackPressed() },
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Black.copy(alpha = iconBackgroundAlpha), shape = CircleShape)
        ) {
            Icon(
                painter = rememberVectorPainter(Icons.Default.ArrowBack),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
private fun Detail(heading: String, detail: String, modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(heading, style = MaterialTheme.typography.h6)
        Text(detail, style = MaterialTheme.typography.subtitle1)
    }
}

@Preview
@Composable
private fun PuppyPreview() {
    MyTheme {
        PuppyDetail(puppy = PuppyData.puppies.first())
    }
}

@Composable
fun PosterCard(
    modifier: Modifier = Modifier,
    puppy: Puppy
) {
    Card(modifier = modifier) {
        Box {

            Text(
                text = puppy.name ?: "No title",
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterStart)
            )
        }

        CoilImage(
            data = puppy.url,
            contentScale = ContentScale.Crop,
            contentDescription = puppy.description,
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
            error = {
                Image(
                    painterResource(R.drawable.not_found),
                    contentDescription = null
                )
            }
        )
    }
}

private const val LORIM =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nulla ipsum, dignissim ut finibus eu, ultricies non velit. Mauris pharetra leo ligula, eget consequat ipsum suscipit molestie. Cras diam orci, imperdiet et sem in, pharetra euismod nunc. Nullam placerat odio mollis dignissim lacinia. Etiam odio lorem, interdum eu fermentum ut, hendrerit sed orci. Integer non cursus ligula. Ut bibendum turpis sit amet placerat ullamcorper. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque dolor mi, consectetur ut justo at, venenatis aliquam nisl. Donec congue lacus non ipsum luctus, vitae finibus dolor suscipit. Aenean sed lectus porta, ullamcorper quam non, pulvinar sem. Sed lectus lorem, cursus eget vestibulum id, volutpat non felis. Sed pulvinar, justo non finibus consectetur, nunc sem convallis sapien, a scelerisque massa elit eget ex.\n" +
        "\n" +
        "Vestibulum feugiat neque faucibus risus bibendum pulvinar. Nulla viverra mi at risus egestas fermentum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Proin facilisis arcu ut commodo pulvinar. Sed dapibus nisi ac mi accumsan mollis. Integer id sagittis sem, a dictum libero. Sed eget aliquet nisi. Fusce venenatis pulvinar elementum. Suspendisse in nibh scelerisque, lobortis sapien sed, tempor nunc. Sed vitae faucibus tortor. Donec finibus enim et porta consectetur."
