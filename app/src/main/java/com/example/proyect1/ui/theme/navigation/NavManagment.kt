package com.example.proyect1.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyect1.ui.theme.viewmodels.ContactsViewModel
import com.example.proyect1.ui.theme.viewmodels.HomeViewModel
import com.example.proyect1.ui.theme.viewmodels.LoginViewModel
import com.example.proyect1.ui.theme.views.ContactsScreen
import com.example.proyect1.ui.theme.views.HomeScreen
import com.example.proyect1.ui.theme.views.LoginScreen

@Composable

fun NavManagment(loginViewModel: LoginViewModel, homeViewModel: HomeViewModel, contactsViewModel: ContactsViewModel) {
    var navController = rememberNavController()
    /**TheTruth, can initializate a viewmodel from the top of a class, in short create an instance
    for future uses**/

    NavHost(navController = navController, startDestination = "Login"){
        composable("Login"){
            LoginScreen(loginViewModel, navController)
        }

        composable("Home"){
            HomeScreen(homeViewModel, navController)
        }

        composable("Contacts"){
            ContactsScreen(contactsViewModel, navController)
        }

    }
}
