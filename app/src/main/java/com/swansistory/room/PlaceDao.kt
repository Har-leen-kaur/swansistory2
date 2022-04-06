package com.swansistory.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlace(place: Place)

    @Query("SELECT * FROM places")
    fun getPlaces() : LiveData<List<Place>>

    @Query("SELECT * FROM places WHERE isFav")
    fun getFavPlaces() : LiveData<List<Place>>

    @Update
    suspend fun updatePlace(place: Place)

}