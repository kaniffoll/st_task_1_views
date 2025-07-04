package com.example.st_task_1_views.screens.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.postscreen.PostAdapter
import com.example.st_task_1_views.databinding.FragmentPostScreenBinding
import com.example.st_task_1_views.extensions.addCustomItemDecoration


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
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val post = args.post
        binding.post = post

        val likeButton = binding.root.findViewById<ImageView>(R.id.likeButton)
        likeButton.setOnClickListener {
            post.isLiked = !post.isLiked
            binding.post = post
        }

        lateinit var adapter: PostAdapter

        adapter = PostAdapter(post.comments) {
            if (adapter.isExpanded()) {
                adapter.showLess()
            } else {
                adapter.showAll()
            }
        }

        binding.commentsRecyclerView.adapter = adapter
        binding.commentsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)
        binding.commentsRecyclerView.addCustomItemDecoration(spacing)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}