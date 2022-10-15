package com.example.deliveryfood.models.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MealDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeals(meal: MealEntity)

    @Query("SELECT * FROM meal_table ORDER BY title ASC")
    fun getMeals(): LiveData<List<MealEntity>>

    @Query("DELETE FROM meal_table")
    fun cleanMealDao()
}