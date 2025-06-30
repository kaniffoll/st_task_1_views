package com.example.st_task_1_views

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.data.adapters.AlbumsAdapter
import com.example.st_task_1_views.data.albumsList


class AlbumsListView : Fragment(R.layout.fragment_albums_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.albumsRecyclerView)

        val currentList = albumsList

        lateinit var adapter: AlbumsAdapter

        adapter = AlbumsAdapter(
            albums = currentList,

            onAlbumClicked = { album ->
//                findNavController()
//                    .navigate()
            },
        )
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)

        recyclerView.addItemDecoration(
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
}
