package com.example.st_task_1_views.handlers

import com.example.st_task_1_views.data.dataclasses.Post

class PostHandler(private val onLike: (Post) -> Unit) {
    fun onLikeClicked(post: Post) {
        onLike(post)
    }
}