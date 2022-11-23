package com.example.deliveryfood.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryfood.models.api.model.*
import com.example.deliveryfood.models.FoodRepository
import com.example.deliveryfood.models.db.CartEntity
import com.example.deliveryfood.models.db.CategoryEntity
import com.example.deliveryfood.models.db.MealEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val repository: FoodRepository) : ViewModel() {

    //LiveData
    private var _categories = repository.getCategoryFromDao()
    val categories: LiveData<List<CategoryEntity>>
        get() = _categories

    private var _mealAllInfo = repository.getMealsFromDao()
    val mealAllInfo: LiveData<List<MealEntity>>
        get() = _mealAllInfo

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCategories(object : Callback<Categories> {
                override fun onResponse(
                    call: Call<Categories>,
                    response: Response<Categories>
                ) {
                    response.body()?.let { responseBody ->
                        responseBody.categories.forEach {
                            viewModelScope.launch(Dispatchers.IO) {
                                repository.insertCategory(CategoryEntity(it.strCategory))
                            }
                        }

                    }
                }

                override fun onFailure(call: Call<Categories>, t: Throwable) {

                }
            })
        }
    }

    fun getMealByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.cleanMealDao()
            repository.getMealByCategory(category, object : Callback<MealList> {
                override fun onResponse(
                    call: Call<MealList>,
                    response: Response<MealList>
                ) {
                    response.body()?.let { responseBody ->

                        responseBody.meals.forEach { meal ->
                            repository.getMealInfo(meal.idMeal, object : Callback<MealInfo> {
                                override fun onResponse(
                                    call: Call<MealInfo>,
                                    response: Response<MealInfo>
                                ) {
                                    response.body()?.let { responseBody ->
                                        responseBody.meals.map {
                                            val newMeal = MealEntity(
                                                title = meal.strMeal,
                                                image = meal.strMealThumb,
                                                description = it.strInstructions
                                            )
                                            viewModelScope.launch(Dispatchers.IO) {
                                                repository.insertMeal(newMeal)
                                            }
                                        }
                                    }
                                }

                                override fun onFailure(call: Call<MealInfo>, t: Throwable) {

                                }
                            })
                        }
                    }
                }

                override fun onFailure(call: Call<MealList>, t: Throwable) {

                }
            })
        }
    }

    fun addClicked(title: String, count: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insetItemToCart(cartItem = CartEntity(title, count))
        }
    }
}