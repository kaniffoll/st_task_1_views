package com.example.st_task_1_views.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.data.dataclasses.Album
import com.example.st_task_1_views.databinding.AlbumCardBinding

class AlbumsAdapter(
    private var albums: List<Album>,
    private val onAlbumClicked: (Album) -> Unit,
) : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(
        private val binding: AlbumCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Album) {
            binding.album = item
            binding.root.setOnClickListener {
                onAlbumClicked(item)
            }
        }
    }

    fun updateAlbums(newAlbums: List<Album>) {
        this.albums = newAlbums
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumViewHolder {
        val binding = AlbumCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AlbumViewHolder(binding)
    }

    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
        holder.bind(albums[position])
}