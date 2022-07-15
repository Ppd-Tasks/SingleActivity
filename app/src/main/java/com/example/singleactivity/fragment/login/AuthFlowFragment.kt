package com.example.singleactivity.fragment.login

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentLoginFlowBinding
import com.example.singleactivity.fragment.BaseFlowFragment

class AuthFlowFragment : BaseFlowFragment(R.layout.fragment_login_flow, R.id.nav_host_fragment_login) {

    private val binding by viewBinding(FragmentLoginFlowBinding::bind)


}