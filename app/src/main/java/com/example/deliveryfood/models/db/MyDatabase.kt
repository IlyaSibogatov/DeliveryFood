package com.example.deliveryfood.models.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CategoryEntity::class, MealEntity::class, CartEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDAO
    abstract fun mealDao(): MealDAO
    abstract fun cartDao(): CartDao
}