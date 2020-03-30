package com.adsandurl.adsandurl.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.adsandurl.adsandurl.model.HotChild;
import com.adsandurl.adsandurl.model.NewChild;

@Database(entities = {HotChild.class, NewChild.class}, version = 1)
public abstract class PostDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "REDDIT_POSTS";

    public abstract PostsDao getPostDao();

}
