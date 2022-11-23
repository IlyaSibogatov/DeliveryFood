package com.example.deliveryfood.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryfood.models.FoodRepository
import com.example.deliveryfood.models.db.CartEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(repository: FoodRepository) : ViewModel() {

    //LiveData
    private var _listItems = repository.getCartItems()
    val listItems: LiveData<List<CartEntity>>
        get() = _listItems

    private val _value = mutableStateOf(0)
    val value: State<Int> get() = _value

    fun changeValue(operator: Boolean) {
        when (operator) {
            true -> _value.value++
            false -> _value.value--
        }
    }

    fun payButtonClicked() {
        /*TODO*/
    }
}