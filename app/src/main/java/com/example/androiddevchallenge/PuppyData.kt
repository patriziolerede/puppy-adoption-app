package com.example.androiddevchallenge

import androidx.annotation.DrawableRes

data class Puppy(
    val url: String,
    val name: String,
    val description: String
)

object PuppyData {
    val puppies = listOf(
        Puppy("https://cdn2.thecatapi.com/images/b2c.gif", "Frank", ""),
        Puppy("https://cdn2.thecatapi.com/images/9rd.jpg", "Lily", ""),
        Puppy("https://cdn2.thecatapi.com/images/kna8ZcDO4.jpg", "Johnnie", ""),
        Puppy("https://cdn2.thecatapi.com/images/793.jpg", "Mary", ""),
        Puppy("https://cdn2.thecatapi.com/images/241.jpg", "Pup", ""),
        Puppy("https://cdn2.thecatapi.com/images/b7r.gif", "Landry", ""),
        Puppy("R.drawable.cat_7", "Snorlax", ""),
        Puppy("R.drawable.cat_8", "Molly", ""),
        Puppy("", "Rex", ""),
        Puppy("R.drawable.cat_10", "Pickle", ""),
    )
}
