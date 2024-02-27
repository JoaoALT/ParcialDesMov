package com.example.proyect1.ui.theme.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyect1.data.Contact

class ContactsViewModel: ViewModel() {

    private val _Name = MutableLiveData<String>()
    val name : LiveData<String> = _Name

    private val _Number = MutableLiveData<String>()
    val number : LiveData<String> = _Number

    private val _Email2 = MutableLiveData<String>()
    val email2 : LiveData<String> = _Email2

    private val _Direction = MutableLiveData<String>()
    val direction : LiveData<String> = _Direction

    private val _ContactList = mutableStateListOf<List<Contact>>()
    val contactList : SnapshotStateList<List<Contact>>
        get() = _ContactList




}