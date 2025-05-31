package com.example.st_task_1_views.utils

object InitialsUtil {
    @JvmStatic
    fun initials(username: String): String {
        return username[0].toString() + (if (username.trimEnd()
                .indexOf(' ') != -1
        ) username[username.indexOf(' ') + 1] else "")
    }
}