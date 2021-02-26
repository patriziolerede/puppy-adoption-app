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

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.ui.theme.MyTheme

class PuppyDetailActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, brand: String) {
            val intent = Intent(context, PuppyDetailActivity::class.java)
            intent.putExtra(PUPPY_NAME_KEY, brand)
            context.startActivity(intent)
        }

        private const val PUPPY_NAME_KEY = "PuppyDetailActivity:puppyNameKey"
    }

    private lateinit var puppyDetailViewModel: PuppyDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbarTitle()
        instantiateViewModel()
        showCarBrandModels()
    }

    private fun instantiateViewModel() {
        puppyDetailViewModel = ViewModelProvider(this).get(PuppyDetailViewModel::class.java)
    }

    private fun ComponentActivity.showCarBrandModels() {
        setContent {
            val carBrandModels by puppyDetailViewModel.getPuppyByName(getPuppyName())
                .observeAsState()
            carBrandModels?.let {
                MyTheme {
                    Surface(color = MaterialTheme.colors.background) { PuppyDetail(it) }
                }
            } ?: finish()
        }
    }

    private fun setToolbarTitle() {
        supportActionBar?.title = getPuppyName()
    }

    private fun getPuppyName() = intent.extras?.getString(PUPPY_NAME_KEY)
}
