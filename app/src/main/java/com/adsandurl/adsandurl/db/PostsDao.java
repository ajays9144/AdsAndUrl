package com.adsandurl.adsandurl.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.adsandurl.adsandurl.model.HotChild;
import com.adsandurl.adsandurl.model.NewChild;

import java.util.List;

@Dao
public interface PostsDao {

    @Insert
    void insertHotPosts(List<HotChild> hotChild);

    @Insert
    void insertNewPosts(List<NewChild> newPosts);

    @Query("SELECT * FROM hot_posts where title LIKE :query")
    List<HotChild> getHotPostsData(String query);

    @Query("SELECT * FROM new_posts where title LIKE :query")
    List<NewChild> getNewPostsData(String query);
}
