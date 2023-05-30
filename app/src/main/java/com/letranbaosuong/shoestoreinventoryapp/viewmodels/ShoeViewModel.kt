package com.letranbaosuong.shoestoreinventoryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.letranbaosuong.shoestoreinventoryapp.models.ShoeModel

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<ShoeModel>>()
    val shoes: LiveData<List<ShoeModel>> get() = _shoes

    fun addShoe(shoe: ShoeModel?) {
        val currentAccounts = _shoes.value.orEmpty().toMutableList()
        shoe?.let { currentAccounts.add(it) }
        _shoes.value = currentAccounts
    }
}