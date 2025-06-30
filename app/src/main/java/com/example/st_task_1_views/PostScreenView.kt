package com.example.st_task_1_views

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.data.adapters.CommentsAdapter
import com.example.st_task_1_views.databinding.FragmentPostScreenBinding
import com.example.st_task_1_views.handlers.PostHandler


class PostScreenView : Fragment() {

    private var _binding: FragmentPostScreenBinding? = null
    private val binding get() = _binding!!

    private val args: PostScreenViewArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_post_screen,
            container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val post = args.post
        binding.post = post

        val handler = PostHandler { updatedPost ->
            updatedPost.isLiked = !updatedPost.isLiked
            binding.invalidateAll()
        }

        binding.handler = handler

        val adapter = CommentsAdapter(post.comments)

        binding.commentsRecyclerView.adapter = adapter
        binding.commentsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)

        binding.commentsRecyclerView.addItemDecoration(
            object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.bottom = spacing
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}