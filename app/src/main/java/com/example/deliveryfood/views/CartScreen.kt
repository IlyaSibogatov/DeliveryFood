package com.example.deliveryfood.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryfood.R
import com.example.deliveryfood.viewmodels.CartViewModel

@Composable
fun CartScreen(viewModel: CartViewModel) {
    Column() {
        CreateTitle()
        CreateItemCard()
    }
}

@Composable
fun CreateTitle() {
    Text(
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(15.dp),
        text = "Your Cart",
        fontSize = 24.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun CreateItemCard() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Random"
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_remove_24),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(15.dp),
                text = "1"
            )
            Image(
                painter = painterResource(id = R.drawable.ic_add_24),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}