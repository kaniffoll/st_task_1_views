package com.example.st_task_1_views.data

import com.example.st_task_1_views.R
import com.example.st_task_1_views.data.dataclasses.Album
import com.example.st_task_1_views.data.dataclasses.Comment
import com.example.st_task_1_views.data.dataclasses.Photo
import com.example.st_task_1_views.data.dataclasses.Post
import com.example.st_task_1_views.data.dataclasses.User

val postsList: List<Post> = listOf(
    Post(id = 0, username = "User 1", title = "Title", description = "Description"),
    Post(id = 1, username = "User 2", title = "Title", description = "Description"),
    Post(id = 2, username = "User 3", title = "Title", description = "Description"),
    Post(id = 3, username = "User 4", title = "Title", description = "Description"),
    Post(
        id = 4,
        username = "User 5",
        title = "Title",
        description = "Description",
        comments = mutableListOf(
            Comment("User 1", "blabla"),
            Comment("User 2", "blabla"),
            Comment("User 3", "blblbbl"),
            Comment("User 4", "blblblb"),
            Comment("User 5", "blablalb")
        )
    )
)

val albumsList: List<Album> = listOf(
    Album(
        id = 0,
        title = "Album 1",
        photos = mutableListOf(
            Photo("User 1", R.drawable.img_1),
            Photo("User 3", R.drawable.img_2),
            Photo("User 2", R.drawable.img_3),
        )
    ),
    Album(
        id = 1,
        title = "Album 2",
        photos = mutableListOf(
            Photo("User 1", R.drawable.img_4),
            Photo("User 1", R.drawable.img_5),
            Photo("User 4", R.drawable.img_6),
        )
    ),
    Album(
        id = 2,
        title = "Album 3",
        photos = mutableListOf(
            Photo("User 5", R.drawable.img_7),
            Photo("User 3", R.drawable.img_8),
            Photo("User 2", R.drawable.img_9),
            Photo("User 1", R.drawable.img_10)
        )
    )
)

const val address = "Воронеж, улица Мира 105"
const val phone = "8 900 100 20 30"

val usersList: List<User> = listOf(
    User(
        name = "User 1",
        username = "@username_1",
        comments = mutableListOf(),
        address = address,
        phone = phone
    ),
    User(
        name = "User 2",
        username = "@username_2",
        comments = mutableListOf(
            "Blablahblahalahblahblhablahhbalhblahb",
            "JBLjBLJBLJBlJBHJHBKHBJKHBKHBKkhbkhbkHBK",
            "jfLJFkljdlkfjLKJFdkljflkdJKLFjlkDfD",
            "jDLKJflDJFLKjkldflkdjLKFJdklfjDLKjfdL"
        ),
        address = address,
        phone = phone
    ),
    User(
        name = "User 3",
        username = "@username_3",
        comments = mutableListOf(
            "BLAhblahblahblah",
            "hJKGHksgdhkjghKjgsd"
        ),
        address = address,
        phone = phone
    ),
    User(
        name = "User 5",
        username = "@username_4",
        comments = mutableListOf(),
        address = address,
        phone = phone
    )
)
