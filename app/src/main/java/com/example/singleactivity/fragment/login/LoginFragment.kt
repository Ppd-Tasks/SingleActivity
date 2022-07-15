package com.example.singleactivity.fragment.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentLoginBinding
import com.example.singleactivity.extension.activityNavController
import com.example.singleactivity.extension.navigateSafely
import com.example.singleactivity.manager.AuthManager

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            bSignin.setOnClickListener {
                AuthManager.isAuthorized = true
                activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
            }

            tvSignup.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
            }
        }
    }
}