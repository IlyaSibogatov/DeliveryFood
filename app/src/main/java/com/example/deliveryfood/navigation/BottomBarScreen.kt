package com.example.deliveryfood.navigation

import com.example.deliveryfood.R
import com.example.deliveryfood.utils.Constants

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Menu : BottomBarScreen(
        route = Constants.MENU_ROUTE,
        title = Constants.MENU,
        icon = R.drawable.ic_fastfood
    )

    object Profile : BottomBarScreen(
        route = Constants.PROFILE_ROUTE,
        title = Constants.PROFILE,
        icon = R.drawable.ic_profile
    )

    object Cart : BottomBarScreen(
        route = Constants.CART_ROUTE,
        title = Constants.CART,
        icon = R.drawable.ic_shopping_basket
    )
}