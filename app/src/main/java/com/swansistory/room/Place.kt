package com.swansistory.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "places")
data class Place(
    var name:String,
    var address:String,
    var imgUrl:String,
    var lat:Double,
    var long:Double,
    var isFav:Boolean,
    var about:String

) : Parcelable {
    constructor() : this("","","",0.0,0.0,UNKNOWN,"")

    companion object TO {
        private val UNKNOWN = false;
    }

    @field:PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
