package com.example.deliveryfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.deliveryfood.navigation.SetupBottomNav
import com.example.deliveryfood.ui.theme.DeliveryFoodTheme
import com.example.deliveryfood.viewmodels.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MenuViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryFoodTheme {
                viewModel.getCategories()
                SetupBottomNav(viewModel)
            }
        }
    }
}