package com.letranbaosuong.shoestoreinventoryapp.models

import android.os.Parcelable


data class ShoeModel(
    var id: Int = -1,
    var name: String = "",
    var size: Int = 0,
    var company: String = "",
    var description: String = "",
)