package com.example.proyect1.ui.theme.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun TextFieldPassword(password: String, onChange: (String) -> Unit){
    TextField(value = password, onValueChange = {
        onChange(it)//it is convention for variable that receivers onChange Function.
    }, visualTransformation = PasswordVisualTransformation())
}

@Composable
fun TextFieldEmail(email: String, onChange: (String) -> Unit){
    TextField(value = email, onValueChange = {
        onChange(it)//it is convention for variable that receivers onChange Function.
    })
}

@Composable
fun ButtonLogin(enable: Boolean, function: () -> Unit){
    Button(onClick = {function()}, enabled = enable){
        Text(text = "Login")
    }
}

