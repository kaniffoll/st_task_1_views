package com.example.st_task_1_views.data

import com.example.st_task_1_views.data.dataclasses.Comment
import com.example.st_task_1_views.data.dataclasses.Post
import com.example.st_task_1_views.data.dataclasses.User

val postsList: List<Post> = listOf(
    Post(username = "User 1", title = "Title", description = "Description"),
    Post(username = "User 2", title = "Title", description = "Description"),
    Post(username = "User 3", title = "Title", description = "Description"),
    Post(username = "User 4", title = "Title", description = "Description"),
    Post(
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

//val albumsList: List<Album> = listOf(
//    Album(
//        name = "Album 1", photos = listOf(
//            Pair("User 1", DrawRes(R.drawable.img_1)),
//            Pair("User 3", DrawRes(R.drawable.img_2)),
//            Pair("User 2", DrawRes(R.drawable.img_3)),
//        )
//    ),
//    Album(
//        name = "Album 2", photos = listOf(
//            Pair("User 1", DrawRes(R.drawable.img_4)),
//            Pair("User 1", DrawRes(R.drawable.img_5)),
//            Pair("User 4", DrawRes(R.drawable.img_6)),
//        )
//    ),
//    Album(
//        name = "Album 3", photos = listOf(
//            Pair("User 10", DrawRes(R.drawable.img_7)),
//            Pair("User 11", DrawRes(R.drawable.img_8)),
//            Pair("User 7", DrawRes(R.drawable.img_9)),
//            Pair("User 9", DrawRes(R.drawable.img_10)),
//        )
//    )
//)

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
