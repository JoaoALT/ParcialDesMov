package com.example.proyect1.ui.theme.views

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import com.example.proyect1.data.Contact
import com.example.proyect1.ui.theme.components.ContactDetailScreen
import com.example.proyect1.ui.theme.components.ContactListScreen
import com.example.proyect1.ui.theme.viewmodels.ContactsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun ContactsScreen(ContactsViewModel: ContactsViewModel, navController: NavHostController) {

    val name:String by ContactsViewModel.name.observeAsState("")
    val email:String by ContactsViewModel.email2.observeAsState("")
    val number:String by ContactsViewModel.number.observeAsState("")
    val direction:String by ContactsViewModel.direction.observeAsState("")


    val selectedContact = remember { mutableStateOf<Contact?>(null) }
    val isLandscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLandscape) {
            Row(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.weight(1f)) {
                    ContactListScreen(onContactClick = { contact ->
                        selectedContact.value = contact
                    })
                }
                Box(modifier = Modifier.weight(1f)) {
                    selectedContact.value?.let { contact ->
                        ContactDetailScreen(contact = contact)
                    }
                }
            }
        } else {
            if (selectedContact.value == null) {
                ContactListScreen( onContactClick = { contact ->
                    selectedContact.value = contact
                })
            } else {
                ContactDetailScreen(contact = selectedContact.value!!)
            }
        }
    }

}