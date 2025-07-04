package com.example.st_task_1_views.adapters.userscreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.data.dataclasses.Comment
import com.example.st_task_1_views.data.dataclasses.User
import com.example.st_task_1_views.resources.AppSettings.INITIAL_COMMENTS_COUNT
import com.example.st_task_1_views.databinding.ItemCommentBinding
import com.example.st_task_1_views.databinding.UserHeaderBinding
import com.example.st_task_1_views.utils.ShowLessMoreUtil

class UserAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<UserScreenItem> = emptyList()

    private var visibleCount = INITIAL_COMMENTS_COUNT
    private val isExpanded: Boolean
        get() = visibleCount >= (currentUser?.comments?.size ?: 0)

    private var currentUser: User? = null

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_COMMENT = 1
        private const val VIEW_TYPE_BUTTON = 2
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(user: User) {
        currentUser = user

        val list = mutableListOf<UserScreenItem>()
        list.add(UserScreenItem.Header(user))

        val comments = user.comments
        val count = minOf(visibleCount, comments.size)
        list.addAll(comments.take(count).map { UserScreenItem.CommentItem(it) })

        if (comments.size > INITIAL_COMMENTS_COUNT) {
            list.add(UserScreenItem.ToggleButton)
        }

        items = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is UserScreenItem.Header -> VIEW_TYPE_HEADER
            is UserScreenItem.CommentItem -> VIEW_TYPE_COMMENT
            is UserScreenItem.ToggleButton -> VIEW_TYPE_BUTTON
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val binding = UserHeaderBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            }

            VIEW_TYPE_BUTTON -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_toggle_button, parent, false)
                ToggleButtonViewHolder(view) {
                    visibleCount = if (isExpanded) {
                        INITIAL_COMMENTS_COUNT
                    } else {
                        currentUser?.comments?.size ?: 0
                    }
                    submitData(currentUser!!)
                }
            }

            else -> {
                val binding = ItemCommentBinding.inflate(inflater, parent, false)
                CommentViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is UserScreenItem.Header -> (holder as HeaderViewHolder).bind(item.user)
            is UserScreenItem.CommentItem -> {
                val comment = item.comment
                (holder as CommentViewHolder).bind(comment.author, comment.message)
            }

            is UserScreenItem.ToggleButton -> {
                (holder as ToggleButtonViewHolder).bind(
                    ShowLessMoreUtil.getShowLessText(holder.itemView.context, isExpanded)
                )
            }
        }
    }

    inner class HeaderViewHolder(private val binding: UserHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }

    inner class ToggleButtonViewHolder(
        binding: View,
        private val onClick: () -> Unit
    ) : RecyclerView.ViewHolder(binding) {
        private val button: TextView = binding.findViewById(R.id.toggleButton)

        init {
            button.setOnClickListener { onClick() }
        }

        fun bind(text: String) {
            button.text = text
        }
    }

    class CommentViewHolder(
        private val binding: ItemCommentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(author: String, message: String) {
            binding.author = author
            binding.message = message
            binding.executePendingBindings()
        }
    }
}


sealed class UserScreenItem {
    data class Header(val user: User) : UserScreenItem()
    data class CommentItem(val comment: Comment) : UserScreenItem()
    data object ToggleButton : UserScreenItem()
}