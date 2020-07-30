package com.example.runningapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.example.runningapp.common.Constatnt.KEY_FIRST_TIME_TOGGLE
import com.example.runningapp.common.Constatnt.KEY_NAME
import com.example.runningapp.common.Constatnt.KEY_WEIGHT
import com.example.runningapp.common.Constatnt.SHARED_PREFERENCES_NAME
import com.example.runningapp.data.RunningDatabase
import com.example.runningapp.data.Shared
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)  // in old dagger we actually had to create those components by ourselves and that really was a lot of
// complicated code but in the new dagger hilt we don't need to do anymore because those components are used to determine when the object inside
//of our app module are created and when  are destroyed
object AppModule {
    // we will declare database instance and we this database become singleton we only want to have a single instance of the room because we won't multiple
    //instance access the database



    //dagger doesn't know from where it should get this context @Application  this solution
    @Provides   // provide and create the depend
    @Singleton   // singlton scope   get single instance hashcode
    fun provideDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(context, RunningDatabase::class.java, "NEWS_DATABASE_NAME")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideDao(db:RunningDatabase)=db.getRunDao()



    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context) = app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(sharedPref: SharedPreferences) = sharedPref.getString(KEY_NAME, "") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPref: SharedPreferences) = sharedPref.getFloat(KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(sharedPref: SharedPreferences) = sharedPref.getBoolean(KEY_FIRST_TIME_TOGGLE, true)



}