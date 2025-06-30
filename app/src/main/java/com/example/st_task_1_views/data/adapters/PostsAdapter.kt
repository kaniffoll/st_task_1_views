package com.example.st_task_1_views.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.data.dataclasses.Post
import com.example.st_task_1_views.databinding.PostCardBinding
import com.example.st_task_1_views.handlers.PostHandler

class PostsAdapter(
    private var posts: List<Post>,
    private val onPostClicked: (Post) -> Unit,
    private val handler: PostHandler
) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    inner class PostViewHolder(
        private val binding: PostCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.post = item
            binding.handler = handler
            binding.root.setOnClickListener {
                onPostClicked(item)
            }
            binding.executePendingBindings()
        }
    }

    fun updatePosts(newPosts: List<Post>) {
        this.posts = newPosts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PostViewHolder(binding)
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(posts[position])

}
