package com.example.runappstor.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.runappstor.Database.LocalDateConverter;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

@Entity(tableName = "Story" ,primaryKeys = {"Code_Story", "Chapter"} ,
        foreignKeys = @ForeignKey(entity = ListStory.class,
        parentColumns = "Code_Story",
        childColumns = "Code_Story",
        onDelete = ForeignKey.CASCADE
))
public class Story {
    @NonNull
    @ColumnInfo(name = "Code_Story")
    @SerializedName("Code_Story")
    private String codeStory;
    @NonNull
    @ColumnInfo(name = "Chapter")
    @SerializedName("Chapter")
    private int chapter;

    @ColumnInfo(name = "Name_Chapter")
    @SerializedName("Name_Chapter")
    private String nameChapter;

    @ColumnInfo(name = "Content")
    @SerializedName("Content")
    private String content;

    @ColumnInfo(name = "Time_Update_Content")
    @SerializedName("Time_Update_Content")
    private String updateDayContent;


    //getter setter

    @NonNull
    public String getCodeStory() {
        return codeStory;
    }

    public void setCodeStory(@NonNull String codeStory) {
        this.codeStory = codeStory;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getNameChapter() {
        return nameChapter;
    }

    public void setNameChapter(String nameChapter) {
        this.nameChapter = nameChapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdateDayContent() {
        return updateDayContent;
    }

    public void setUpdateDayContent(String updateDayContent) {
        this.updateDayContent = updateDayContent;
    }
}

