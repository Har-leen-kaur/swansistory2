package com.swansistory.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.swansistory.room.Place
import com.swansistory.room.PlaceDao
import com.swansistory.room.PlaceDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val placeDao:PlaceDao = PlaceDatabase.getDatabase(application).placeDao()
    val placeList:LiveData<List<Place>> = placeDao.getPlaces()
    val favPlaceList:LiveData<List<Place>> = placeDao.getFavPlaces()

    fun setPlaceFavourite(place: Place){
        viewModelScope.launch(Dispatchers.IO) {
            placeDao.updatePlace(place)
        }
    }

    fun addPlace(place: Place) {
        viewModelScope.launch(Dispatchers.IO) {
            placeDao.addPlace(place)
        }
    }
}