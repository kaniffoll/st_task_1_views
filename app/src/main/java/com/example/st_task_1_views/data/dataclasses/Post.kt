package com.example.st_task_1_views.data.dataclasses

data class Post(
    val id: Int,
    val username: String,
    val title: String,
    val description: String,
    val comments: MutableList<Comment> = mutableListOf(),
    var isLiked: Boolean = false
) : java.io.Serializable
