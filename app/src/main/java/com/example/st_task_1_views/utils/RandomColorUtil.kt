package com.example.st_task_1_views.utils

import android.graphics.Color
import kotlin.random.Random

object RandomColorUtil {
    @JvmStatic
    fun getRandomColorByUserName(username: String): Int {
        val seed = username.hashCode().toLong()
        val random = Random(seed)
        return Color.rgb(
            random.nextInt(1, 256),
            random.nextInt(1, 256),
            random.nextInt(1, 256)
        )
    }
}