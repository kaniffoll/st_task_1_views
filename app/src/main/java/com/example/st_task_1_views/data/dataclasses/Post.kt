package com.example.st_task_1_views.data.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val username: String,
    val title: String,
    val description: String,
    val comments: MutableList<Comment> = mutableListOf()
) : java.io.Serializable
