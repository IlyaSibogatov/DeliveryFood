package com.example.deliveryfood.models.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewItemToCart(cartItem: CartEntity)

    @Query("SELECT * FROM cart_table ORDER BY title ASC")
    fun getCartItems(): LiveData<List<CartEntity>>
}