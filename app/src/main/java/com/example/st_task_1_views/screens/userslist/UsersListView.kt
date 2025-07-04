package com.example.st_task_1_views.screens.userslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.userslist.UsersAdapter
import com.example.st_task_1_views.data.usersList
import com.example.st_task_1_views.extensions.addCustomItemDecoration

class UsersListView : Fragment(R.layout.fragment_users_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.usersRecyclerView)

        val currentList = usersList

        val adapter = UsersAdapter(users = currentList) { user ->
            findNavController()
                .navigate(UsersListViewDirections.actionUsersToUserScreenView(user))
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)
        recyclerView.addCustomItemDecoration(spacing)
    }
}