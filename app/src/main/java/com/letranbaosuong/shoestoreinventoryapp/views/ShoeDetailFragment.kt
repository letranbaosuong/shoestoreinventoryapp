package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentShoeDetailBinding
import com.letranbaosuong.shoestoreinventoryapp.viewmodels.ShoeDetailViewModel
import com.letranbaosuong.shoestoreinventoryapp.viewmodels.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    private val _shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var _shoeDetailViewModel: ShoeDetailViewModel
    private lateinit var _shoeDetailBinding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _shoeDetailBinding =
            FragmentShoeDetailBinding.inflate(inflater, container, false)
        _shoeDetailViewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        _shoeDetailBinding.shoeDetail = _shoeDetailViewModel
        _shoeDetailBinding.lifecycleOwner = this
        _shoeDetailBinding.apply {
            cancelButton.setOnClickListener {
                view?.findNavController()?.popBackStack()
            }
            saveButton.setOnClickListener {
                _shoeViewModel.addShoe(_shoeDetailViewModel.shoe.value)
                view?.findNavController()?.popBackStack()
            }
        }
        _shoeDetailBinding.shoeViewModel = _shoeViewModel
        return _shoeDetailBinding.root
    }
}