package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.R
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentLoginBinding
import com.letranbaosuong.shoestoreinventoryapp.models.AccountModel
import com.letranbaosuong.shoestoreinventoryapp.viewmodels.AccountViewModel

class LoginFragment : Fragment() {
    private lateinit var _accountViewModel: AccountViewModel
    private lateinit var _loginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _accountViewModel = ViewModelProvider(this)[AccountViewModel::class.java]
        _accountViewModel.account.observe(viewLifecycleOwner) { accounts ->
            Log.i("registerAccount::", accounts.last().userName.toString())
        }
        _loginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        _loginBinding.apply {
            loginButton.setOnClickListener {
                val userName = usernameEdit.text.toString()
                val password = passwordEdit.text.toString()
                val account = AccountModel(userName, password)
                val isExist = _accountViewModel.isCheckAccountExists(account)
                if (isExist) {
                    it.findNavController().navigate(R.id.welcomeFragment)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Tài khoản $userName chưa được đăng ký. Vui lòng đăng ký tài khoản!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            registerButton.setOnClickListener {
                val userName = usernameEdit.text.toString()
                val password = passwordEdit.text.toString()
                registerAccount(userName, password)
            }
        }

        return _loginBinding.root
    }

    private fun registerAccount(userName: String?, password: String?) {
        val newAccount = AccountModel(userName, password)
        _accountViewModel.addAccount(newAccount)
        Toast.makeText(requireContext(), "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
    }
}