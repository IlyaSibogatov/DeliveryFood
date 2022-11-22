package com.example.deliveryfood.viewmodels

import androidx.lifecycle.ViewModel
import com.example.deliveryfood.models.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: FoodRepository): ViewModel(){
}