package com.example.deliveryfood.models.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewItemToCart(cartItem: CartEntity)

    @Query("SELECT * FROM cart_table ORDER BY title ASC")
    fun getCartItems(): LiveData<List<CartEntity>>

    @Update
    fun updateItemCart(cartItem: CartEntity)

    @Query("DELETE FROM cart_table")
    fun paid()

    @Delete
    fun deleteItem(item: CartEntity)
}