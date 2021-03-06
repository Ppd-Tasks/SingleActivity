package com.example.singleactivity.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.singleactivity.R
import com.example.singleactivity.manager.AuthManager

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        Handler(Looper.myLooper()!!).postDelayed({
            when{
                AuthManager.isAuthorized ->{
                    findNavController().navigate(R.id.action_splashFragment_to_mainFlowFragment)
                }

                !AuthManager.isAuthorized ->{
                    findNavController().navigate(R.id.action_splashFragment_to_loginFlowFragment)
                }
            }
        },5000)

        return view
    }

}