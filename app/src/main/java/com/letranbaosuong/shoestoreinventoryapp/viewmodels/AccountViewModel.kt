package com.letranbaosuong.shoestoreinventoryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.letranbaosuong.shoestoreinventoryapp.models.AccountModel

class AccountViewModel : ViewModel() {
    private val _accounts = MutableLiveData<List<AccountModel>>()
    val account: LiveData<List<AccountModel>> get() = _accounts

    fun addAccount(account: AccountModel) {
        val currentAccounts = _accounts.value.orEmpty().toMutableList()
        currentAccounts.add(account)
        _accounts.value = currentAccounts
    }

    fun isCheckAccountExists(account: AccountModel): Boolean {
        return _accounts.value.orEmpty().toMutableList().contains(account)
    }
}