package com.assignment.netclan.data

import com.assignment.netclan.R

data class DummyData(
    val name: String,
    val location: String,
    val photo: Int,
    val tags: String,
    val message: String
)

val dummyData = listOf<DummyData>(
    DummyData(
        name = "Michael Murphy",
        location = "San Francisco, within 1 Km",
        photo = R.drawable.image1,
        tags = "Friendship | Coffee | Hangout",
        message = "Hi community! I am open to new connections."
    ),
    DummyData(
        name = "John Doe",
        location = "San Francisco, within 1 Km",
        photo = R.drawable.image2,
        tags = "Coffee | Movies | Hobbies",
        message = "Going to Berkley, would love to share a ride with someone like minded."
    ),
    DummyData(
        name = "Murphy Michael",
        location = "San Francisco, within 1 Km",
        photo = R.drawable.image3,
        tags = "Friendship | Coffee | Hangout",
        message = "Hi community! I am open to new connections."
    ),
    DummyData(
        name = "Adam John",
        location = "San Francisco, within 1 Km",
        photo = R.drawable.image4,
        tags = "Friendship | Coffee | Hangout",
        message = "Hi community! I am open to new connections."
    ),
    DummyData(
        name = "Timmy Smith",
        location = "San Francisco, within 1 Km",
        photo = R.drawable.image5,
        tags = "Friendship | Coffee | Hangout",
        message = "Hi community! I am open to new connections."
    )
)
