package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.R
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var _welcomeBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _welcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        _welcomeBinding.continueBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }
        return _welcomeBinding.root
    }

}