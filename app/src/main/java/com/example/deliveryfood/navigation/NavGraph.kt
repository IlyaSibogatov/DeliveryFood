package com.example.deliveryfood.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deliveryfood.viewmodels.MenuViewModel
import com.example.deliveryfood.views.MenuScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: MenuViewModel) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Menu.route
    ) {
        composable(route = BottomBarScreen.Menu.route) {
            MenuScreen(viewModel)
        }
        composable(route = BottomBarScreen.Profile.route) {

        }
        composable(route = BottomBarScreen.Basket.route) {

        }
    }
}