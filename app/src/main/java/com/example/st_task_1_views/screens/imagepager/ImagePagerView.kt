package com.example.st_task_1_views.screens.imagepager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.example.st_task_1_views.MainActivity
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.imagepager.ImagePagerAdapter

class ImagePagerView : Fragment(R.layout.fragment_image_pager) {

    private val args: ImagePagerViewArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagePager = view.findViewById<ViewPager2>(R.id.imagePager)
        val photos = args.album.photos
        val id = args.photoId

        val adapter = ImagePagerAdapter(
            photos = photos
        )

        imagePager.adapter = adapter
        imagePager.setCurrentItem(id, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? MainActivity)?.imagePagerOpened(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        (activity as? MainActivity)?.imagePagerOpened(false)
        super.onDestroyView()
    }
}