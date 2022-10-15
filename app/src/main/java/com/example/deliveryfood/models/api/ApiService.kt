package com.example.deliveryfood.models.api

import com.example.deliveryfood.models.api.model.Categories
import com.example.deliveryfood.models.api.model.MealInfo
import com.example.deliveryfood.models.api.model.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    fun getAllCategories(): Call<Categories>

    @GET("filter.php?c=")
    fun getMealByCategory(@Query("c") category: String): Call<MealList>

    @GET("lookup.php?i=")
    fun getInfoById(@Query("i") id: String) : Call<MealInfo>
}
