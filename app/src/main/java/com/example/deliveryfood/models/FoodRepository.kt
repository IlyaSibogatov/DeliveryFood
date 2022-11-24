package com.example.deliveryfood.models

import androidx.lifecycle.LiveData
import com.example.deliveryfood.models.api.ApiService
import com.example.deliveryfood.models.api.model.Categories
import com.example.deliveryfood.models.api.model.MealInfo
import com.example.deliveryfood.models.api.model.MealList
import com.example.deliveryfood.models.db.*
import retrofit2.Callback
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val apiService: ApiService,
    private val categoryDAO: CategoryDAO,
    private val mealDAO: MealDAO,
    private val cartDao: CartDao
) {

    fun getAllCategories(callback: Callback<Categories>) {
        apiService.getAllCategories().enqueue(callback)
    }

    fun getMealByCategory(category: String, callback: Callback<MealList>) {
        apiService.getMealByCategory(category).enqueue(callback)
    }

    fun getMealInfo(id: String, callback: Callback<MealInfo>) {
        apiService.getInfoById(id).enqueue(callback)
    }

    fun insertCategory(category: CategoryEntity) {
        categoryDAO.insertCategoryList(category)
    }

    fun getCategoryFromDao(): LiveData<List<CategoryEntity>> {
        return categoryDAO.getCategories()
    }

    fun insertMeal(meal: MealEntity) {
        mealDAO.insertMeals(meal)
    }

    fun getMealsFromDao(): LiveData<List<MealEntity>> {
        return mealDAO.getMeals()
    }

    fun cleanMealDao() {
        mealDAO.cleanMealDao()
    }

    fun insetItemToCart(cartItem: CartEntity) {
        cartDao.insertNewItemToCart(cartItem)
    }

    fun getCartItems(): LiveData<List<CartEntity>> {
        return cartDao.getCartItems()
    }

    fun updateItemCart(cartItem: CartEntity) {
        cartDao.updateItemCart(cartItem)
    }

    fun cartPaid() {
        cartDao.paid()
    }

    fun deleteItem(item: CartEntity) {
        cartDao.deleteItem(item)
    }
}