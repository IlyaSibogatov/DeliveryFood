package com.example.deliveryfood.models.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryList(category: CategoryEntity)

    @Query("SELECT * FROM category_table ORDER BY title ASC")
    fun getCategories(): LiveData<List<CategoryEntity>>
}