package com.letranbaosuong.shoestoreinventoryapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.letranbaosuong.shoestoreinventoryapp.R
import com.letranbaosuong.shoestoreinventoryapp.databinding.FragmentShoeListScrollingBinding
import com.letranbaosuong.shoestoreinventoryapp.viewmodels.ShoeViewModel

class ShoeListScrollingFragment : Fragment() {
    private val _shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var _shoeListScrollingBinding: FragmentShoeListScrollingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _shoeListScrollingBinding = FragmentShoeListScrollingBinding.inflate(
            inflater, container, false
        )
        _shoeListScrollingBinding.lifecycleOwner = this
        _shoeListScrollingBinding.apply {
            addButton.setOnClickListener {
                view?.findNavController()?.navigate(R.id.shoeDetailFragment)
            }
        }
        _shoeViewModel.shoes.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                it.forEach { itemShoe ->
                    val shoeItemLayout = ShoeItemLayout(activity, itemShoe)
                    _shoeListScrollingBinding.listShoe.addView(shoeItemLayout)
                }
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