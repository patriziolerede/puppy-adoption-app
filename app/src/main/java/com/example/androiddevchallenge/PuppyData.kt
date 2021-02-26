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
