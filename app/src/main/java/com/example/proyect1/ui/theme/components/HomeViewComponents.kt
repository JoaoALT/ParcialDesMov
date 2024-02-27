package com.example.proyect1.ui.theme.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextFieldName(name: String, onChange: (String) -> Unit){
    TextField(value = name, onValueChange = {
        onChange(it)//it is convention for variable that receivers onChange Function.
    })
}

@Composable
fun TextFieldNumber(number: String, onChange: (String) -> Unit){
    TextField(keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),value = number, onValueChange = {
        onChange(it)//it is convention for variable that receivers onChange Function.
    })
}
@Composable
fun TextFieldEmail2(email: String, onChange: (String) -> Unit){
    TextField(value = email, onValueChange = {
        onChange(it)//it is convention for variable that receivers onChange Function.
    })
}
@Composable
fun TextFieldDirection(direction: String, onChange: (String) -> Unit){
    TextField(value = direction, onValueChange = {
        onChange(it)//it is convention for variable that receivers onChange Function.
    })
}

@Composable
fun ButtonContacts(function: () -> Unit){
    Button(onClick = {function()}){
        Text(text = "Contacts")
    }
}

@Composable
fun AddButtonContacts(function: () -> Unit){
    Button(onClick = {function()}){
        Text(text = "Add")
    }
}