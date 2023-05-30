package com.letranbaosuong.shoestoreinventoryapp.views

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.letranbaosuong.shoestoreinventoryapp.databinding.ShoeItemBinding
import com.letranbaosuong.shoestoreinventoryapp.models.ShoeModel

class ShoeItemLayout(context: Context?, shoe: ShoeModel) : LinearLayout(context) {
    private var _shoeItemBinding: ShoeItemBinding

    init {
        _shoeItemBinding = ShoeItemBinding.inflate(LayoutInflater.from(context), this, true)
        _shoeItemBinding.shoe = shoe
        _shoeItemBinding.root
    }

    fun itemShoe(shoe: ShoeModel) {
        _shoeItemBinding.apply {
            addView(this.root)
            shoeNameShow.text = shoe.name
            shoeCompanyShow.text = shoe.company
            shoeSizeShow.text = shoe.size.toString()
            shoeDescriptionShow.text = shoe.description
        }
    }
}