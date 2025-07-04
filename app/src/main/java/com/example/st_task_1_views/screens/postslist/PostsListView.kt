package com.example.st_task_1_views.screens.postslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.postslist.PostsAdapter
import com.example.st_task_1_views.data.postsList
import com.example.st_task_1_views.extensions.addCustomItemDecoration

class PostsListView : Fragment(R.layout.fragment_posts_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.postsRecyclerView)

        var currentList = postsList

        lateinit var adapter: PostsAdapter

        adapter = PostsAdapter(
            posts = currentList,

            onPostClicked = { post ->
                findNavController()
                    .navigate(PostsListViewDirections.actionPostsListToPostScreen(post))
            },

            onPostLiked = { likedPost ->
                val index = currentList.indexOfFirst { it.id == likedPost.id }
                if (index != -1) {
                    val updatedPost = currentList[index].copy(isLiked = !currentList[index].isLiked)
                    val updatedList = currentList.toMutableList().apply {
                        set(index, updatedPost)
                    }
                    currentList = updatedList
                    adapter.updatePosts(updatedList)
                    adapter.notifyItemChanged(index)
                }
            },
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)
        recyclerView.addCustomItemDecoration(spacing)
    }
}