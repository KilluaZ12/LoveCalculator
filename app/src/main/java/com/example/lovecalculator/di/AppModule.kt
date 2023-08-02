package com.example.lovecalculator.di

import android.content.Context
import androidx.room.Room
import com.example.lovecalculator.data.local.Pref
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.room.AppDatabase
import com.example.lovecalculator.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApi::class.java)
    }

    @Provides
    fun providePref(@ApplicationContext context: Context): Pref = Pref(context)

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun provideLoveDao(@ApplicationContext context: Context): LoveDao {
        return provideAppDatabase(context).loveDao()
    }

}