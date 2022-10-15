package com.example.deliveryfood.navigation

import com.example.deliveryfood.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Menu : BottomBarScreen(
        route = "menu_screen",
        title = "Menu",
        icon = R.drawable.ic_fastfood
    )

    object Profile : BottomBarScreen(
        route = "profile_screen",
        title = "Profile",
        icon = R.drawable.ic_profile
    )

    object Basket : BottomBarScreen(
        route = "basket_screen",
        title = "Basket",
        icon = R.drawable.ic_shopping_basket
    )
}