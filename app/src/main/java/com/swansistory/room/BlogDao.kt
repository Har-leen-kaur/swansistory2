package com.swansistory.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface BlogDao {
    @Query("SELECT * FROM blog_post")
    fun getBlogPosts() : LiveData<List<Blog>>

    @Insert(onConflict = REPLACE)
    suspend fun addBlogPost(blog: Blog)
}