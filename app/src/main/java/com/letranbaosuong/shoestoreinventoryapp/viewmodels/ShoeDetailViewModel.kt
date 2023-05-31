package com.letranbaosuong.shoestoreinventoryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.letranbaosuong.shoestoreinventoryapp.models.ShoeModel

class ShoeDetailViewModel : ViewModel() {
    private val _shoe = MutableLiveData<ShoeModel>()
    val shoe: LiveData<ShoeModel> get() = _shoe

    init {
        _shoe.value = ShoeModel()
    }

    fun setName(value: String) {
        _shoe.value?.name = value
    }

    fun getName(): String {
        return _shoe.value?.name.toString()
    }

    fun setCompany(value: String) {
        _shoe.value?.company = value
    }

    fun getCompany(): String {
        return _shoe.value?.company.toString()
    }

    fun setDescription(value: String) {
        _shoe.value?.description = value
    }

    fun getDescription(): String {
        return _shoe.value?.description.toString()
    }

    fun setSize(value: String) {
        if (value.isNotEmpty()) {
            _shoe.value?.size = value.toInt()
        } else {
            _shoe.value?.size = 0
        }
    }

    fun getSize(): String {
        return (_shoe.value?.size ?: 0).toString()
    }
}