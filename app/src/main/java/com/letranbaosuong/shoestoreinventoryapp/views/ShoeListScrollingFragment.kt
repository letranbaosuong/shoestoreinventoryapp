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
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentShoeListScrollingBinding

class ShoeListScrollingFragment : Fragment() {
    private lateinit var _shoeListScrollingBinding: FragmentShoeListScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _shoeListScrollingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list_scrolling,
            container,
            false
        )
        _shoeListScrollingBinding.apply {
            addButton.setOnClickListener {
                view?.findNavController()?.navigate(R.id.shoeDetailFragment)
            }
        }
        return _shoeListScrollingBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.app_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.menu_logout -> {
                        view.findNavController().navigate(R.id.loginFragment)
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}