package com.example.runappstor.EntityDao;


import android.database.Cursor;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.runappstor.Entity.ListStory;

import java.util.List;

@Dao
public interface ListStoryDao  {
    @Insert
    long insertListStory(ListStory listStory);

//    onConflict = OnConflictStrategy.REPLACE
    @Insert()
    void insertAllStory(List<ListStory> stories);

    @Update
    void updateListStory(ListStory listStory);


    @Query("SELECT Avatar_story FROM ListStory WHERE Code_Story = :code")
    String getImageUrlByCode(String code);

    @Query("SELECT Name_Story FROM ListStory WHERE Code_Story = :code")
    String getNameStory(String code);
    @Query("SELECT Author FROM ListStory WHERE Code_Story = :code")
    String getAuthor(String code);
    @Query("SELECT Production_Date FROM ListStory WHERE Code_Story = :code")
    String getProductionDay(String code);
    @Query("SELECT Update_Day FROM ListStory WHERE Code_Story = :code")
    String getUpdateDay(String code);


    @Query("SELECT * FROM ListStory")
    List<ListStory> getAllListStories();

}