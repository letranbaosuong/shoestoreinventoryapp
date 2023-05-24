package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.R
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentShoeDetailBinding
import com.letranbaosuong.shoestoreinventoryapp.viewmodels.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var _shoeViewModel: ShoeViewModel
    private lateinit var _shoeDetailBinding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _shoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        _shoeDetailBinding.lifecycleOwner = this
        _shoeDetailBinding.apply {
            cancelButton.setOnClickListener {
                view?.findNavController()?.popBackStack()
            }
            saveButton.setOnClickListener {
                _shoeViewModel.addShoe(_shoeDetailBinding.shoe)
                view?.findNavController()?.popBackStack()
            }
        }
        _shoeViewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        _shoeDetailBinding.shoeViewModel = _shoeViewModel
        return _shoeDetailBinding.root
    }
}