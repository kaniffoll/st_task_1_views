package com.example.st_task_1_views.data.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val username: String,
    val comments: MutableList<String>,
    val address: String,
    val phone: String
)