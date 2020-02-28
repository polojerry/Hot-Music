package com.polotechnologies.hotmusic.uiHost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.polotechnologies.hotmusic.R
import com.polotechnologies.hotmusic.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var mBinding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        setupBottomNavigation()
        return mBinding.root
    }

    private fun setupBottomNavigation() {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_home) as NavHostFragment

        mBinding.bottomNavMain
            .setupWithNavController(navController = navHostFragment.navController)
    }

}
