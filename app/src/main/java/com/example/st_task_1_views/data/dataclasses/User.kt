package com.example.st_task_1_views.data.dataclasses

data class User(
    val name: String,
    val username: String,
    val comments: MutableList<Comment> = mutableListOf(),
    val address: String,
    val phone: String
) : java.io.Serializable