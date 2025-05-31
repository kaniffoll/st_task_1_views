package com.example.st_task_1_views.data.dataclasses

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class DrawRes(
    @DrawableRes val photo: Int
)

@Serializable
data class Album(
    val name: String,
    val photos: List<Pair<String, DrawRes>>
)