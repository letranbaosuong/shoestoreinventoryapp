package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.R
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private var _isEditing: Boolean = false
    private lateinit var _welcomeBinding: FragmentWelcomeBinding

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.app_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.menu_logout -> {
//                view?.findNavController()?.navigate(R.id.loginFragment)
//                true
//            }
//
//            else -> false
//        }
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu) {
//        super.onPrepareOptionsMenu(menu)
//        val item = menu.findItem(R.id.menu_logout)
//        item.isVisible = _isEditing
//    }

//    fun updateOptionsMenu() {
//        _isEditing = !_isEditing
//        requireActivity().invalidateOptionsMenu()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _welcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        _welcomeBinding.continueBtn.setOnClickListener {
            it.findNavController().navigate(R.id.instructionsFragment)
        }
        return _welcomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        _welcomeBinding.appToolbar.inflateMenu(R.menu.app_menu)
//        _welcomeBinding.appToolbar.setOnMenuItemClickListener {
//            when (it.itemId) {
//                R.id.menu_logout -> {
//                    view.findNavController().navigate(R.id.loginFragment)
//                    true
//                }
//
//                else -> false
//            }
//        }
    }

//    fun updateToolbar() {
//        _isEditing = !_isEditing
//
//        val saveItem = _welcomeBinding.appToolbar.menu.findItem(R.id.menu_logout)
//        saveItem.isVisible = _isEditing
//
//    }
//
//    fun clearToolbarMenu() {
//        _welcomeBinding.appToolbar.menu.clear()
//    }

//    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//        menuInflater.inflate(R.menu.app_menu, menu)
//    }
//
//    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//        return when (menuItem.itemId) {
//            R.id.menu_logout -> {
//                view?.findNavController()?.navigate(R.id.loginFragment)
//                true
//            }
//
//            else -> false
//        }
//    }
}