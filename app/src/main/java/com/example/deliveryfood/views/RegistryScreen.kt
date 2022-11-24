package com.example.deliveryfood.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.deliveryfood.utils.Constants
import com.example.deliveryfood.viewmodels.RegistryViewModel

@Composable
fun RegistryScreen(viewModel: RegistryViewModel = hiltViewModel()) {

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = Constants.REGISTRY
        )
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text(text = Constants.LOGIN_TEXT) },
            placeholder = { Text(text = Constants.LOGIN_TEXT) }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = Constants.PASSWORD_TEXT) },
            placeholder = { Text(text = Constants.PASSWORD_TEXT) }
        )
        Button(
            onClick = { /*TODO*/ }) {
            Text(text = Constants.APPLY)
        }
    }
}