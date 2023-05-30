package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentShoeDetailBinding
import com.letranbaosuong.shoestoreinventoryapp.models.ShoeModel
import com.letranbaosuong.shoestoreinventoryapp.viewmodels.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    private val _shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var _shoeDetailBinding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _shoeDetailBinding =
            FragmentShoeDetailBinding.inflate(inflater, container, false)
        _shoeDetailBinding.lifecycleOwner = this
        _shoeDetailBinding.apply {
            cancelButton.setOnClickListener {
                view?.findNavController()?.popBackStack()
            }
            saveButton.setOnClickListener {
                val shoe = ShoeModel()
                shoe.name = _shoeDetailBinding.editShoeName.text.toString()
                shoe.company = _shoeDetailBinding.editCompany.text.toString()
                shoe.size = Integer.parseInt(_shoeDetailBinding.editShoeSize.text.toString())
                shoe.description = _shoeDetailBinding.editTextDescription.text.toString()
                _shoeViewModel.addShoe(shoe)
                view?.findNavController()?.popBackStack()
            }
        }
        _shoeDetailBinding.shoeViewModel = _shoeViewModel
        return _shoeDetailBinding.root
    }
}