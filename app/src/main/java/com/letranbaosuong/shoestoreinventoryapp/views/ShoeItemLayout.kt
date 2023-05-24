package com.letranbaosuong.shoestoreinventoryapp.views

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.letranbaosuong.shoestoreinventoryapp.R
import com.letranbaosuong.shoestoreinventoryapp.databinding.ShoeItemBinding
import com.letranbaosuong.shoestoreinventoryapp.models.ShoeModel

class ShoeItemLayout : LinearLayout {
    constructor(context: Context) : super(context)

    private val _shoeItemBinding: ShoeItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.id.shoeItemCardView, this, false
    )

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