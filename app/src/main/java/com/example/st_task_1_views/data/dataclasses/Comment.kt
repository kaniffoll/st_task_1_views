package com.example.st_task_1_views.data.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val author: String,
    val message: String
) : java.io.Serializable