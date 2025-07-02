package com.example.st_task_1_views.screens.user

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.userscreen.UserAdapter

class UserScreenView : Fragment(R.layout.fragment_user_screen) {

    private  lateinit var adapter: UserAdapter

    private val args: UserScreenViewArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserAdapter()

        val user = args.user

        val recyclerView = view.findViewById<RecyclerView>(R.id.userScreenRecyclerView)

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

        adapter.submitData(user)
    }
}