package com.example.st_task_1_views.screens.album

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.albumscreen.PhotosAdapter
import com.example.st_task_1_views.extensions.addCustomItemDecoration

class AlbumScreenView : Fragment(R.layout.fragment_album_screen) {

    private val args: AlbumScreenViewArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val album = args.album
        val photos = album.photos

        val adapter = PhotosAdapter(
            photos = photos,
            onPhotoClicked = {
                findNavController()
                    .navigate(
                        AlbumScreenViewDirections.actionAlbumScreenToImagePagerView(
                            album,
                            it
                        )
                    )
            }
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.albumScreenRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)

        recyclerView.addCustomItemDecoration(spacing)
    }
}