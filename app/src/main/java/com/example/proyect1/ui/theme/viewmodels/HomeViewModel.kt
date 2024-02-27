package com.example.proyect1.ui.theme.viewmodels

import android.util.Patterns
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel(){

    private val _Name = MutableLiveData<String>()
    val name : LiveData<String> = _Name

    private val _Number = MutableLiveData<String>()
    val number : LiveData<String> = _Number

    private val _Email2 = MutableLiveData<String>()
    val email2 : LiveData<String> = _Email2

    private val _Direction = MutableLiveData<String>()
    val direction : LiveData<String> = _Direction

    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled : LiveData<Boolean> = _isEnabled


    fun onHomeChange(name: String, number: String, direction: String, email: String){
        _Name.value = name

        if (number.isDigitsOnly()) {_Number.value = number}
        _Direction.value = direction
        _Email2.value = email
        _isEnabled.value = isValid(email, number)

    }

    fun isReset(condition: Boolean){
        if (condition) {
            _Name.value = ""
            _Number.value = ""
            _Email2.value = ""
            _Direction.value = ""
        }
    }

    private fun isValid(email: String, number: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && number.length == 10;
    }
}