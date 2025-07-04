package com.example.st_task_1_views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentMain) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.Posts, R.id.Photos, R.id.Users, R.id.Todos)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavMenu)
        bottomNav.itemIconTintList = null
        NavigationUI.setupWithNavController(bottomNav, navController)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.toolbar)) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            view.setPadding(
                view.paddingLeft,
                statusBarHeight,
                view.paddingRight,
                view.paddingBottom
            )
            insets
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun imagePagerStateChanged(isDisplayed: Boolean) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (isDisplayed) {
            toolbar.setBackgroundColor(getColor(R.color.black))
            toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.back_icon_white)
        } else {
            toolbar.setBackgroundColor(getColor(R.color.white))
            toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.back_icon_black)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavMenu)
        bottomNav.visibility = if (isDisplayed) View.GONE else View.VISIBLE
    }
}