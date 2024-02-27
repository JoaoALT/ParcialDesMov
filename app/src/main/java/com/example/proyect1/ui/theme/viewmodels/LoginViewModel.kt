package com.example.proyect1.ui.theme.viewmodels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled : LiveData<Boolean> = _isEnabled

    fun onLoginChange(email: String, password: String){
        _email.value = email
        _password.value = password
        _isEnabled.value = isValid(email, password)
    }
    private fun isValid(email: String, password: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6;
    }


    //return Patterns.EMAIL_ADDRESS.matches(email).matches()




}