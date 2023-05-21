package com.letranbaosuong.shoestoreinventoryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.letranbaosuong.shoestoreinventoryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _activityMainBinding: ActivityMainBinding
    private lateinit var _appBarConfiguration: AppBarConfiguration
    private lateinit var _appNavControl: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        _appNavControl =
            (supportFragmentManager
                .findFragmentById(R.id.app_navigator_fragment)
                    as NavHostFragment).navController
        _appBarConfiguration = AppBarConfiguration(_appNavControl.graph)
        NavigationUI.setupActionBarWithNavController(this, _appNavControl)
        setContentView(_activityMainBinding.root)
    }

    override fun onNavigateUp(): Boolean =
        _appNavControl.navigateUp() || super.onSupportNavigateUp() || _appNavControl.popBackStack()
}