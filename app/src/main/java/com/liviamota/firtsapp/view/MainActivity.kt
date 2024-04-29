package com.liviamota.firtsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.liviamota.firtsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Criar a toolbar
    private lateinit var appBarConfiguration: AppBarConfiguration

    //Criar a navegação
    private lateinit var navController: NavController

    //Criar o binding
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Configura o binding
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Configura anavegação e a toolbar
        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}