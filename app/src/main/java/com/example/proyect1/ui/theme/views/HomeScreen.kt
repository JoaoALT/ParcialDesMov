package com.example.proyect1.ui.theme.views

import android.annotation.SuppressLint
import android.provider.ContactsContract.Contacts
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyect1.R
import com.example.proyect1.ui.theme.components.AddButtonContacts
import com.example.proyect1.ui.theme.components.ButtonContacts
import com.example.proyect1.ui.theme.components.ButtonLogin
import com.example.proyect1.ui.theme.components.ContactListScreen
import com.example.proyect1.ui.theme.components.TextFieldDirection
import com.example.proyect1.ui.theme.components.TextFieldEmail2
import com.example.proyect1.ui.theme.components.TextFieldName
import com.example.proyect1.ui.theme.components.TextFieldNumber
import com.example.proyect1.ui.theme.components.addContact
import com.example.proyect1.ui.theme.viewmodels.ContactsViewModel
import com.example.proyect1.ui.theme.viewmodels.HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun HomeScreen(HomeViewModel: HomeViewModel, navController: NavHostController) {

    val name:String by HomeViewModel.name.observeAsState("")
    val email:String by HomeViewModel.email2.observeAsState("")
    val number:String by HomeViewModel.number.observeAsState("")
    val direction:String by HomeViewModel.direction.observeAsState("")

    Scaffold(
        //whole screengrid
    ){
        Column(

            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painterResource(R.drawable.catty), "suck")
            Row{
                Image(
                    painterResource(R.drawable.like),
                    "likeimage",
                    )
            }

            //name number direc email

            Text(text = "Nombre")

            TextFieldName(name = name){
                HomeViewModel.isReset(false)
                HomeViewModel.onHomeChange(it, number, direction, email)
            }
            Text(text = "Numero de telefono")

            TextFieldNumber(number = number){
                HomeViewModel.isReset(false)
                HomeViewModel.onHomeChange(name, it, direction, email)
            }
            Text(text = "Email")

            TextFieldEmail2(email = email){
                HomeViewModel.isReset(false)
                HomeViewModel.onHomeChange(name, number, direction, it)
            }
            Text(text = "Direccion")

            TextFieldDirection(direction = direction){
                HomeViewModel.isReset(false)
                HomeViewModel.onHomeChange(name, number, it, email)
            }

            Row(){
                AddButtonContacts {
                    addContact(name,number,email,direction)
                    HomeViewModel.isReset(true)

                }
                ButtonContacts(){
                    navController.navigate("Contacts")
                }
            }


        }

    }

}


