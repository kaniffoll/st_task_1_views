package com.example.st_task_1_views.screens.todo

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.st_task_1_views.R
import com.example.st_task_1_views.adapters.todoslist.TodosAdapter
import com.example.st_task_1_views.data.dataclasses.Todo
import com.example.st_task_1_views.extensions.addCustomItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TodoScreenView : Fragment(R.layout.fragment_todo_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todos: MutableList<Todo> = mutableListOf()

        val adapter = TodosAdapter(
            todos = todos
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.todoRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)

        val spacing = resources.getDimensionPixelSize(R.dimen.padding_medium)
        recyclerView.addCustomItemDecoration(spacing)

        @Suppress("ClickableViewAccessibility")
        recyclerView.setOnTouchListener { _, _ ->
            requireActivity().currentFocus?.let { focused ->
                focused.clearFocus()
                val imm =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(focused.windowToken, 0)
            }
            return@setOnTouchListener false
        }

        val fab = view.findViewById<FloatingActionButton>(R.id.todoFab)
        fab.setOnClickListener {
            val newTodo = Todo(id = todos.size, title = "")
            todos.add(newTodo)
            adapter.notifyItemInserted(todos.size - 1)
        }

        val root = view.findViewById<View>(R.id.todoRootLayout)
        root.setOnClickListener {
            root.requestFocus()
            val imm =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(root.windowToken, 0)
        }
    }
}