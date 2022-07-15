package com.example.singleactivity.fragment.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentSignUpBinding
import com.example.singleactivity.extension.activityNavController
import com.example.singleactivity.extension.navigateSafely
import com.example.singleactivity.manager.AuthManager

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private val binding by viewBinding(FragmentSignUpBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.apply {

            tvSignin.setOnClickListener {
                //findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
                findNavController().popBackStack()
            }
        }
    }
}