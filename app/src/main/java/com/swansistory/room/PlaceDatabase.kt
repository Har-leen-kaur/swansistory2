package com.swansistory.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Place::class,Blog::class],version = 1)
abstract class PlaceDatabase : RoomDatabase() {

    abstract fun placeDao() : PlaceDao
    abstract fun blogDao() : BlogDao


    companion object {
        @Volatile
        private var INSTANCE:PlaceDatabase? = null

        fun getDatabase(context:Context) : PlaceDatabase {
            val tempInit = INSTANCE
            if(tempInit != null) return tempInit
            synchronized(this) {
                val instance = Room.databaseBuilder(context,PlaceDatabase::class.java,"place_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}