package com.example.runappstor.Database;

import android.content.Context;
import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.runappstor.Entity.Comment;
import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.Entity.Story;
import com.example.runappstor.Entity.User;
import com.example.runappstor.EntityDao.CommentDao;
import com.example.runappstor.EntityDao.ListStoryDao;
import com.example.runappstor.EntityDao.StoryDao;
import com.example.runappstor.EntityDao.UserDao;


@Database(entities = {User.class, Story.class, ListStory.class, Comment.class}, version = 1,exportSchema = false)
@TypeConverters({LocalDateConverter.class})
public abstract class CreateDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "DataStory.db";
    private static CreateDatabase instance;


    public abstract UserDao userDao();
    public abstract ListStoryDao listStoryDao();
    public abstract StoryDao storyDao();
    public abstract CommentDao commentDao();

    //nhan dl api


    public static synchronized CreateDatabase getInstance(Context context) {
        if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                                CreateDatabase.class, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
        }
        return instance;
    }

}





