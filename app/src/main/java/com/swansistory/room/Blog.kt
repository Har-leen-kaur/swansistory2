package com.swansistory.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "blog_post")
data class Blog(val title: String, val imgUrl: String, val data: String) : Parcelable {

    constructor() : this("","", myData)

    companion object TO {
        private val myData = ""
    }

    @field:PrimaryKey(autoGenerate = true)
    var id:Int = 0
}