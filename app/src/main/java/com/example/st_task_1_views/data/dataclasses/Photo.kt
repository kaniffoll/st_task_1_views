package com.example.st_task_1_views.data.dataclasses

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val title: String,
    @DrawableRes var photo: Int = 0
)
