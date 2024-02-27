package com.example.proyect1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.proyect1.ui.theme.navigation.NavManagment
import com.example.proyect1.ui.theme.Proyect1Theme
import com.example.proyect1.ui.theme.viewmodels.ContactsViewModel
import com.example.proyect1.ui.theme.viewmodels.HomeViewModel
import com.example.proyect1.ui.theme.viewmodels.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyect1Theme {
                // A surface container using the 'background' color from the theme
                NavManagment(LoginViewModel(), HomeViewModel(), ContactsViewModel())
            }
        }
    }
}
