package com.example.st_task_1_views.adapters.postscreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.data.dataclasses.Comment
import com.example.st_task_1_views.resources.AppSettings.INITIAL_COMMENTS_COUNT
import com.example.st_task_1_views.databinding.ItemCommentBinding
import com.example.st_task_1_views.utils.ShowLessMoreUtil

class PostAdapter(
    private val comments: List<Comment>,
    private val onToggleClick: () -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_COMMENT = 0
        private const val TYPE_TOGGLE_BUTTON = 1
    }

    private var visibleCount = INITIAL_COMMENTS_COUNT

    inner class CommentViewHolder(
        private val binding: ItemCommentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(author: String, message: String) {
            binding.author = author
            binding.message = message
            binding.executePendingBindings()
        }
    }

    inner class ToggleButtonViewHolder(
        itemView: View, private val onClick: () -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val button: TextView = itemView.findViewById(R.id.toggleButton)

        init {
            button.setOnClickListener { onClick() }
        }

        fun bind(text: String) {
            button.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_COMMENT) {
            val binding =
                ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CommentViewHolder(binding)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_toggle_button, parent, false)
            ToggleButtonViewHolder(view, onToggleClick)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommentViewHolder) {
            val comment = comments[position]
            holder.bind(comment.author, comment.message)
        } else if (holder is ToggleButtonViewHolder) {
            holder.bind(
                ShowLessMoreUtil.getShowLessText(
                    context = holder.itemView.context,
                    isExpanded = isExpanded()
                )
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun showAll() {
        visibleCount = comments.size
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun showLess() {
        visibleCount = INITIAL_COMMENTS_COUNT
        notifyDataSetChanged()
    }

    fun isExpanded(): Boolean = visibleCount >= comments.size

    override fun getItemCount(): Int {
        val showToggleButton = comments.size > INITIAL_COMMENTS_COUNT
        val displayedCount = minOf(visibleCount, comments.size)
        return if (showToggleButton) displayedCount + 1 else displayedCount
    }

    override fun getItemViewType(position: Int): Int {
        val showToggleButton = comments.size > INITIAL_COMMENTS_COUNT
        val displayedCount = minOf(visibleCount, comments.size)
        return if (showToggleButton && position == displayedCount) {
            TYPE_TOGGLE_BUTTON
        } else {
            TYPE_COMMENT
        }
    }
}