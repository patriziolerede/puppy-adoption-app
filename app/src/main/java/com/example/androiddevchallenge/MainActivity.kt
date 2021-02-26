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
package com.example.androiddevchallenge

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.catdetail.PuppyDetailActivity
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.color1
import com.example.androiddevchallenge.ui.theme.color2
import com.example.androiddevchallenge.ui.theme.color3
import com.example.androiddevchallenge.ui.theme.color4
import com.example.androiddevchallenge.ui.theme.color5
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                ProvideWindowInsets {
                    Surface {
                        MyApp()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Header() {
    Column(
        Modifier
            .border(2.dp, MaterialTheme.colors.primary)
            .background(
                Brush.horizontalGradient(
                    0.0f to color1,
                    0.25f to color2,
                    0.50f to color3,
                    0.75f to color4,
                    1.0f to color5
                )
            )
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Adopt a Cat", style = MaterialTheme.typography.overline)
        Text(text = "Choose your \uD83D\uDC31!", style = MaterialTheme.typography.h4)
    }
    Spacer(modifier = Modifier.size(16.dp))
}

@ExperimentalFoundationApi
@Composable
fun MyApp() {

    val context = LocalContext.current
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize()
    ) {
        stickyHeader {
            Header()
        }
        items(PuppyData.puppies) {
            Box(Modifier.padding(8.dp)) {
                PuppyView(
                    puppy = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clickable { onItemSelect(context, it) }
                )
            }
        }
    }
}

private fun onItemSelect(context: Context, puppy: Puppy) =
    (context as? Activity).apply {
        PuppyDetailActivity.getIntent(context, puppy.name)
    }

@OptIn(ExperimentalFoundationApi::class)
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
