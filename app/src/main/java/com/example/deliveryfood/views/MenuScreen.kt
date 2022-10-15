package com.example.deliveryfood.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryfood.R
import com.example.deliveryfood.models.db.CategoryEntity
import com.example.deliveryfood.models.db.MealEntity
import com.example.deliveryfood.utils.MyUtils
import com.example.deliveryfood.viewmodels.MenuViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MenuScreen(viewModel: MenuViewModel) {

    val categoryList by viewModel.categories.observeAsState()
    val mealList by viewModel.mealAllInfo.observeAsState()

    Column {
        CitiesDropDownMenu()
        categoryList?.let { listCategory ->
            mealList?.let { listMeal ->
                SetScreen(listCategory, listMeal, viewModel)
            }
        }
    }
}

@Composable
fun CitiesDropDownMenu() {
    val citiesList = listOf("London", "Paris", "Berlin")
    val expanded = remember { mutableStateOf(false) }
    val currentValue = remember { mutableStateOf(citiesList[0]) }
    Row(modifier = Modifier
        .padding(10.dp)
        .clickable {
            expanded.value = !expanded.value
        }) {
        Text(
            text = currentValue.value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)

        DropdownMenu(expanded = expanded.value, onDismissRequest = {
            expanded.value = false
        }) {
            citiesList.forEach { city ->
                DropdownMenuItem(onClick = {
                    currentValue.value = city
                    expanded.value = false
                }) {
                    Text(
                        text = city,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun Banners() {
    val bannerList = listOf(
        R.drawable.pizza,
        R.drawable.steak,
        R.drawable.salade,
        R.drawable.soda,
        R.drawable.coffee
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(bannerList) { item ->
            Card(
                modifier = Modifier
                    .padding(15.dp),
                shape = MaterialTheme.shapes.small,
                elevation = 4.dp
            ) {
                Image(
                    painter = painterResource(id = item),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun Categories(categoryList: List<CategoryEntity>, viewModel: MenuViewModel) {
    val context = LocalContext.current
    LazyRow(
        modifier = Modifier
            .background(color = White)
            .padding(15.dp)
    ) {
        items(categoryList) { item ->
            Text(
                text = item.title,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        if (MyUtils.isInternetAvailable(context)) {
                            viewModel.getMealByCategory(item.title)
                        }
                    }
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(Color.Gray)
    ) {}
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetScreen(
    categoryList: List<CategoryEntity>,
    mealList: List<MealEntity>,
    viewModel: MenuViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        item() {
            Banners()
        }

        stickyHeader {
            Categories(categoryList, viewModel)
        }

        items(mealList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    GlideImage(
                        imageModel = item.image,
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        ),
                        modifier = Modifier.weight(1F)
                    )
                    Column(
                        modifier = Modifier.weight(1F)
                    ) {
                        Text(
                            text = item.title,
                            modifier = Modifier
                                .padding(15.dp),
                            fontSize = 18.sp
                        )
                        Text(
                            text = item.description,
                            modifier = Modifier
                                .padding(15.dp),
                            fontSize = 14.sp,
                            maxLines = 10,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}