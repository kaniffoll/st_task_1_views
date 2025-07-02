package com.example.st_task_1_views.data.dataclasses

import androidx.annotation.DrawableRes

data class Photo(
    val title: String,
    @DrawableRes var photo: Int = 0
) : java.io.Serializable
