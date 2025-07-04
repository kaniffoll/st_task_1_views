package com.example.st_task_1_views.screens.albumslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.albumslist.AlbumsAdapter
import com.example.st_task_1_views.data.albumsList
import com.example.st_task_1_views.extensions.addCustomItemDecoration


class AlbumsListView : Fragment(R.layout.fragment_albums_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.albumsRecyclerView)

        val currentList = albumsList

        val adapter = AlbumsAdapter(
            albums = currentList,

            onAlbumClicked = { album ->
                findNavController()
                    .navigate(AlbumsListViewDirections.actionPhotosToAlbumScreenView(album))
            },
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)
        recyclerView.addCustomItemDecoration(spacing)
    }
}
