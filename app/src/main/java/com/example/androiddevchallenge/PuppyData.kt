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

data class Puppy(
    val url: String,
    val name: String,
    val description: String
)

object PuppyData {
    val puppies = listOf(
        Puppy("https://cdn2.thecatapi.com/images/b2c.gif", "John", ""),
        Puppy("https://cdn2.thecatapi.com/images/9rd.jpg", "Pipy", ""),
        Puppy("https://cdn2.thecatapi.com/images/kna8ZcDO4.jpg", "Lay", ""),
        Puppy("https://cdn2.thecatapi.com/images/793.jpg", "Lucky", ""),
        Puppy("https://cdn2.thecatapi.com/images/241.jpg", "Pippo", ""),
        Puppy("https://cdn2.thecatapi.com/images/b7r.gif", "Capagross", ""),
        Puppy("", "Polpo", ""),
        Puppy("https://cdn2.thecatapi.com/images/dib.jpg", "Capamazz", ""),
        Puppy("", "Regina", ""),
        Puppy("https://cdn2.thecatapi.com/images/6o8.jpg", "Filippo", ""),
    )
}
