package com.example.st_task_1_views.data.dataclasses

data class Album(
    val id: Int,
    val title: String,
    val photos: MutableList<Photo> = mutableListOf()
) : java.io.Serializable