package com.example.deliveryfood.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(
    @PrimaryKey
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "count") var count: Int
)