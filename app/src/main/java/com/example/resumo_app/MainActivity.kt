package com.example.resumo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //appBar é a parte superior
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //estanciando as variaveis para criar a funcao de voltar - abaixo
        navController = findNavController(R.id.navHost)
        //passar os fragments que nao terão a seta de voltar
        appBarConfiguration = AppBarConfiguration.Builder(R.id.splashFragment, R.id.feedFragment).build()
        //appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    //funcao para voltar (botao superior)
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}