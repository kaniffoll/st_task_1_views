package com.example.st_task_1_views.adapters.albumscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.data.dataclasses.Photo
import com.example.st_task_1_views.databinding.PhotoCardBinding

class PhotosAdapter(
    private val photos: List<Photo>,
    private val onPhotoClicked: (Int) -> Unit
) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    inner class PhotoViewHolder(
        private val binding: PhotoCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Photo, position: Int) {
            binding.photo = item
            binding.photoCardImageView.setImageResource(item.photo)
            binding.root.setOnClickListener {
                onPhotoClicked(position)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = PhotoCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) =
        holder.bind(photos[position], position)
}