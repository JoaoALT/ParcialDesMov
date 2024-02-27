package com.example.proyect1.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyect1.R
import com.example.proyect1.data.Contact


var contactList = mutableListOf(
    Contact( "John Doe", "123-456-7890","john@gmail.com","cra 23"),
    Contact( "Jane Smith", "987-654-3210","jane@gmail.com","calle 20"),
    Contact( "Alex Johnson", "555-123-4567","Alex@gmail.com","cra 1"),
    Contact( "Celeb David", "4741-123-4567","Caleb@gmail.com","calle 100"),
    Contact( "Rickey", "888-854-5147","Ricky@gmail.com","cra 100"),
    Contact( "Cameron Green", "888-515-8754","Green@gmail.com","cra 51"),
    Contact("Adam Warner", "548-453-5545","Warner@gmail.com","cra 12")
)

@Composable
fun ContactListScreen(onContactClick: (Contact) -> Unit) {
    LazyColumn {
        items(contactList) { contact ->
            ContactItem(contact = contact, onContactClick = onContactClick)
        }
    }
}

fun addContact(name : String, phone : String, email: String, direction: String){
    contactList.add(Contact(name,phone,email,direction))
}

fun deleteContact(personitaa: Contact){
    contactList.remove(personitaa)
}



@Composable
fun ContactItem(contact: Contact, onContactClick: (Contact) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onContactClick(contact) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = contact.name)
            Text(text = contact.phone)
            ButtonContactsDelete(conct = contact){}
        }

    }
}

@Composable
fun ButtonContactsDelete(conct: Contact,function: () -> Unit){
    Button(onClick = { deleteContact(conct)}){
        Text(text = "Delete")
    }
}

@Composable
fun ContactDetailScreen(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = contact.name)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = contact.phone)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = contact.email)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = contact.direction)
    }
}