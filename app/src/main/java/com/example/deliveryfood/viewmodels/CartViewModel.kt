package com.example.deliveryfood.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.models.FoodRepository
import com.example.deliveryfood.models.db.CartEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repository: FoodRepository) : ViewModel() {

    //LiveData
    private var _listItems = repository.getCartItems()
    val listItems: LiveData<List<CartEntity>>
        get() = _listItems

    fun changeValue(operator: Boolean, cartItem: CartEntity) {
        var count = cartItem.count
        when (operator) {
            true -> {
                count++
                updateItem(cartItem.title, count)
            }
            false -> {
                count--
                updateItem(cartItem.title, count)
            }
        }
    }

    fun payButtonClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.cartPaid()
        }
    }

    private fun updateItem(title: String, count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItemCart(cartItem = CartEntity(title, count))
        }
    }

    fun deleteItemFromCart(item: CartEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(item)
        }
    }
}