package com.example.st_task_1_views.adapters.todoslist

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.data.dataclasses.Todo
import com.example.st_task_1_views.databinding.TodoCardBinding

class TodosAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodosAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(
        private val binding: TodoCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Todo) {
            binding.todoCardEditText.setText(item.title)

            binding.todoCardEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    item.title = p0.toString()
                }

                override fun afterTextChanged(p0: Editable?) {}
            })

            binding.todoCardEditText.setOnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    item.title = binding.todoCardEditText.text.toString()
                    val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }

            binding.todoCardIcon.setOnClickListener {
                val position = adapterPosition
                todos.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TodoViewHolder(binding)
    }

    override fun getItemCount() = todos.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }
}