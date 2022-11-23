package com.example.deliveryfood.di

import android.content.Context
import androidx.room.Room
import com.example.deliveryfood.models.api.ApiService
import com.example.deliveryfood.models.db.CartDao
import com.example.deliveryfood.models.db.CategoryDAO
import com.example.deliveryfood.models.db.MealDAO
import com.example.deliveryfood.models.db.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrl() = "https://themealdb.com/api/json/v1/1/"

    @Provides
    @Singleton
    fun providerRetrofit(baseUrl: String): ApiService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    fun provideCategoryDao(myDatabase: MyDatabase): CategoryDAO{
        return myDatabase.categoryDao()
    }

    @Provides
    fun provideMealDao(myDatabase: MyDatabase): MealDAO{
        return myDatabase.mealDao()
    }

    @Provides
    fun provideCartDao(myDatabase: MyDatabase): CartDao{
        return myDatabase.cartDao()
    }

    @Provides
    @Singleton
    fun provideMyDatabase(@ApplicationContext appContext: Context): MyDatabase{
        return Room.databaseBuilder(
            appContext,
            MyDatabase::class.java,
            "MyDatabase"
        ).build()
    }
}