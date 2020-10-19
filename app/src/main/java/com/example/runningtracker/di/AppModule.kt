package com.example.runningtracker.di

import android.content.Context
import androidx.room.Room
import com.example.runningtracker.other.Constants.RUNNING_DATABASE_NAME
import com.example.runningtracker.db.RunningDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
@Singleton
@Provides
    fun provideRunningDatabase(@ApplicationContext app : Context) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun getRunDao(db:RunningDatabase)=db.getRunDao()



}