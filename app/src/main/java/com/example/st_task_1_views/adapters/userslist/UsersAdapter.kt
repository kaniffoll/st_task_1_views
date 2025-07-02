package com.example.st_task_1_views.adapters.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.data.dataclasses.User
import com.example.st_task_1_views.databinding.UserCardBinding

class UsersAdapter(
    private var users: List<User>,
    private val onUserCardClicked: (User) -> Unit,
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    inner class UserViewHolder(
        private val binding: UserCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User) {
            binding.user = item
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                onUserCardClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(users[position])

}