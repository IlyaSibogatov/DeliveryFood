package com.example.deliveryfood.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.deliveryfood.R
import com.example.deliveryfood.models.db.CartEntity
import com.example.deliveryfood.utils.Constants
import com.example.deliveryfood.viewmodels.CartViewModel

@Composable
fun CartScreen(viewModel: CartViewModel = viewModel()) {

    val itemsList by viewModel.listItems.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(viewModel)
        itemsList?.let { CartList(viewModel, it) }
    }
}

@Composable
fun AppBar(viewModel: CartViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .background(color = Color.Gray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .padding(15.dp),
            text = Constants.YOUR_CART,
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Button(
            modifier = Modifier.padding(15.dp),
            onClick = {
                viewModel.payButtonClicked()
            }) {
            Text(
                text = Constants.PAY
            )
        }
    }
}

@Composable
fun CartList(viewModel: CartViewModel, list: List<CartEntity>) {
    LazyColumn() {
        items(list) { item ->
            Row(
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = item.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = { viewModel.changeValue(false) }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_remove_24),
                            contentDescription = Constants.CONTENT_DESCRIPTION
                        )
                    }
                    Text(
                        modifier = Modifier.padding(15.dp),
                        text = viewModel.value.value.toString()
                    )
                    IconButton(
                        onClick = { viewModel.changeValue(true) }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_add_24),
                            contentDescription = Constants.CONTENT_DESCRIPTION
                        )
                    }
                }
            }
        }
    }
}