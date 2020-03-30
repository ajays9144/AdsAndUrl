package com.adsandurl.adsandurl.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.adsandurl.adsandurl.model.Data;
import com.adsandurl.adsandurl.model.NewPosts;

@Dao
public interface PostsDao {

    @Insert
    void insertHotPosts(Data data);

    @Insert
    void insertNewPosts(NewPosts newPosts);

    @Query("SELECT * FROM hot_posts")
    Data getHotPostsData();

    @Query("SELECT * FROM new_posts")
    NewPosts getNewPostsData();
}
