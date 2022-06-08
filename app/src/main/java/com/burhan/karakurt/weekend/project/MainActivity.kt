package com.burhan.karakurt.weekend.project

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.burhan.karakurt.weekend.common.base.ui.BaseActivity
import com.burhan.karakurt.weekend.project.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            topLevelDestinationIds =
            setOf(
                com.burhan.karakurt.weekend.character_list.R.id.navigation_character_list,
            )
        )
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}