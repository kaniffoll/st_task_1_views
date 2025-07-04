package com.example.st_task_1_views.utils

import android.content.Context
import com.example.st_task_1_views.R

object ShowLessMoreUtil {
    fun getShowLessText(context: Context, isExpanded: Boolean): String {
        return if (isExpanded) {
            context.getString(R.string.show_less)
        } else {
            context.getString(R.string.show_more)
        }
    }
}