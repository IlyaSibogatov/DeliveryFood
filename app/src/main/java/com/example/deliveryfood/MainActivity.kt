package com.example.deliveryfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.deliveryfood.navigation.MainScreen
import com.example.deliveryfood.ui.theme.DeliveryFoodTheme
import com.example.deliveryfood.viewmodels.CartViewModel
import com.example.deliveryfood.viewmodels.MenuViewModel
import com.example.deliveryfood.viewmodels.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val menuViewModel: MenuViewModel by viewModels()
        val profileViewModel: ProfileViewModel by viewModels()
        val cartViewModel: CartViewModel by viewModels()
        super.onCreate(savedInstanceState)

        setContent {
            DeliveryFoodTheme {
                menuViewModel.getCategories()
                MainScreen(menuViewModel, profileViewModel, cartViewModel)
            }
        }
    }
}