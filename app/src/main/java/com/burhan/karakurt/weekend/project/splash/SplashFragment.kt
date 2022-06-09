package com.burhan.karakurt.weekend.project.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.burhan.karakurt.weekend.common.base.ui.BaseFragment
import com.burhan.karakurt.weekend.project.R
import com.burhan.karakurt.weekend.project.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(SPLASH_NAVIGATION_DELAY)
            navigateToListFragment()
        }
    }

    private fun navigateToListFragment() {
        findNavController().navigate(SplashFragmentDirections.actionNavigationSplashToNavigationList())
    }

    companion object {
        private const val SPLASH_NAVIGATION_DELAY: Long = 2000
    }
}