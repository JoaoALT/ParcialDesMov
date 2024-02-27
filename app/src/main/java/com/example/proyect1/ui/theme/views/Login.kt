package com.example.proyect1.ui.theme.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyect1.ui.theme.viewmodels.LoginViewModel
import com.example.proyect1.ui.theme.components.ButtonLogin
import com.example.proyect1.ui.theme.components.TextFieldPassword
import com.example.proyect1.ui.theme.components.TextFieldEmail

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navController: NavHostController) {

    val email:String by loginViewModel.email.observeAsState("")
    val password:String by loginViewModel.password.observeAsState("")
    val isEnabled:Boolean by loginViewModel.isEnabled.observeAsState(initial = false)


    Scaffold(
        //whole screengrid
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(text = "Email")

            TextFieldEmail(email){
                loginViewModel.onLoginChange(it,password)
            }

            Text(text = "Password")

            TextFieldPassword(password){
                loginViewModel.onLoginChange(email,it)
            }

            ButtonLogin(isEnabled){
                navController.navigate("Home")
            }

        }
    }
}

