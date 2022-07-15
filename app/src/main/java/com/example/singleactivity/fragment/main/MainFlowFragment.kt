package com.example.singleactivity.fragment.main

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentMainFlowBinding
import com.example.singleactivity.fragment.BaseFlowFragment

class MainFlowFragment : BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_fragment_main) {

    private val binding by viewBinding(FragmentMainFlowBinding::bind)

    override fun setUpNavigation(navController: NavController) {
        super.setUpNavigation(navController)
        binding.bottomNavigation.setupWithNavController(navController)
    }

}