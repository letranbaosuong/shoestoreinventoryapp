package com.letranbaosuong.shoestoreinventoryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(_activityMainBinding.root)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        _appNavControl.popBackStack()
    }

    override fun onSupportNavigateUp(): Boolean {
        return _appNavControl.navigateUp() || super.onSupportNavigateUp() || _appNavControl.popBackStack()
    }
}