package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.R
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var _instructionsBinding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _instructionsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        _instructionsBinding.apply {
            nextButton.setOnClickListener {
                view?.findNavController()?.navigate(R.id.shoeListScrollingFragment)
            }
        }
        return _instructionsBinding.root
    }
}