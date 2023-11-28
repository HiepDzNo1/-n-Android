package com.example.runappstor.EntityDao;
import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.runappstor.Entity.Story;

import java.util.List;

@Dao
public interface StoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllInformationStory(List<Story> story);
    @Query("SELECT Chapter, Name_Chapter, Content FROM Story WHERE Code_Story = :code AND Chapter = :chuong")
    Cursor getContentByCode(String code, int chuong);

    @Query("SELECT * FROM Story WHERE Code_Story = :code")
    List<Story> getListChapterStoryByCode(String code);
}
