package com.example.deliveryfood.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deliveryfood.viewmodels.CartViewModel
import com.example.deliveryfood.viewmodels.MenuViewModel
import com.example.deliveryfood.viewmodels.ProfileViewModel
import com.example.deliveryfood.views.CartScreen
import com.example.deliveryfood.views.MenuScreen
import com.example.deliveryfood.views.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Menu.route
    ) {
        composable(route = BottomBarScreen.Menu.route) {
            MenuScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Cart.route) {
            CartScreen()
        }
    }
}