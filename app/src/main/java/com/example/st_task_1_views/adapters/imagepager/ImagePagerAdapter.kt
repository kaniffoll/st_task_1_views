package com.example.st_task_1_views.adapters.imagepager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.data.dataclasses.Photo

class ImagePagerAdapter(private val photos: List<Photo>) : RecyclerView.Adapter<ImagePagerAdapter.ImagePagerViewHolder>() {

    inner class ImagePagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(photo: Photo) {
            imageView.setImageResource(photo.photo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return ImagePagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagePagerViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount() = photos.size
}